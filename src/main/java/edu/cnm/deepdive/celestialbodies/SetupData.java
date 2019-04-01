package edu.cnm.deepdive.celestialbodies;

import android.preference.Preference;
import antlr.Tool;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import edu.cnm.deepdive.celestialbodies.model.dao.StarRepository;
import edu.cnm.deepdive.celestialbodies.model.entity.Star;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class SetupData {

  private static final Logger LOG
      = LoggerFactory.getLogger(DataBasePopulator.class);

  //private static final Tool LOG = new Tool() ;

  private StarRepository starRepository;

  public SetupData(StarRepository starRepository) {
    this.starRepository = starRepository;
  }

  public void setupData(){

    setupStars();

  }

  public void setupStars() {

    List<Star> stars = loadObjectList(Star.class, "raw/hygdata_v3.csv");

    starRepository.saveAll(stars);

    LOG.debug("Finished Loading Data");

  }

  /**
   * Creates the CSVSchema based on first “header” row. The implementation is generic enough to
   * handle any type of object. If any error occurs, an empty list will be returned.
   *
   * @param type data type to be loaded
   * @param fileName name of the data file
   * @param <T> Generic type parameter to allow DataBasePopulator to be inputted.
   * @return Returns a type-safe empty, immutable {@link List}
   */
  public <T> List<T> loadObjectList(Class<T> type, String fileName) {
    try {
      CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
      CsvMapper mapper = new CsvMapper();
      File file = new ClassPathResource(fileName).getFile();
      MappingIterator<T> readValues =
          mapper.reader(type).with(bootstrapSchema).readValues(file);
      return readValues.readAll();
    } catch (Exception e) {
      LOG.error("Error occurred while loading object list from file " + fileName, e);
      return Collections.emptyList();
    }
  }

  /**
   * Nested objects are not well supported in Jackson CSV – this is an indirect load many to many
   * relationships.These will be represented similar to simple join tables – so naturally it loads
   * from disk as a list of arrays.
   *
   * @param fileName name of file with data to be loaded into database
   * @return Returns a type-safe empty, immutable {@link List}
   */
  public List<String[]> loadManyToManyRelationship(String fileName) {
    try {
      CsvMapper mapper = new CsvMapper();
      CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
      mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
      File file = new ClassPathResource(fileName).getFile();
      MappingIterator<String[]> readValues =
          mapper.reader(String[].class).with(bootstrapSchema).readValues(file);
      return readValues.readAll();
    } catch (Exception e) {
      LOG.error(
          "Error occurred while loading many to many relationship from file = " + fileName, e);
      return Collections.emptyList();
    }
  }


}
