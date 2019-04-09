package edu.cnm.deepdive.celestialbodies.model.dao;

import edu.cnm.deepdive.celestialbodies.model.entity.Star;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


/** Declares basic CRUD operations for {@link Star} instances in the server database,
 * using Spring Boot annotations. This repository declares methods by which data established in the Star
 * entity will be accessed.
 */
public interface StarRepository extends CrudRepository<Star, Long> {


  /**
   * Selects and returns 10 {@link Star} instances, sorted by Absmag.
   *
   * @return {@link List} sequence of {@link Star} instances.
   */
  List<Star> findFirst10ByOrderByAbsmag();

  /**
   * Selects and returns {@link Star} Id.
   *
   * @return {@link List} of {@link Star} Id.
   */
  List<Star> findAllByOrderByIdAsc();

  /**
   * Selects and returns {@link Star} Proper name.
   *
   * @return {@link List} {@link Star} Proper.
   */
  List<Star> findAllByOrderByProper();

}
