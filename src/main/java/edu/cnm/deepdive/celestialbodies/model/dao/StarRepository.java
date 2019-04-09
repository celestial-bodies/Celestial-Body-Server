package edu.cnm.deepdive.celestialbodies.model.dao;

import android.widget.ListView;
import edu.cnm.deepdive.celestialbodies.model.entity.Star;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;


/** Declares basic CRUD operations for {@link Star} instances in the server database,
 * using Spring Boot annotations. This repository declares methods by which data established in the Star
 * entity will be accessed.
 */

public interface StarRepository extends CrudRepository<Star, Long> {

  List<Star> findFirst10ByOrderByAbsmag();

  List<Star> findAllByOrderByIdAsc();

  List<Star> findAllByOrderByAbsmag();

  List<Star> findAllByOrderByHipAsc();

  List<Star> findAllByOrderByHdAsc();

  List<Star> findAllByOrderByHrAsc();

  List<Star> findAllByOrderByProper();

}
