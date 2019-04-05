package edu.cnm.deepdive.celestialbodies.model.dao;

import edu.cnm.deepdive.celestialbodies.model.entity.Star;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface declares methods by which data established in the Star entity will be accessed.
 */

public interface StarRepository extends CrudRepository<Star, Long> {

  List<Star> findAllByOrderByIdAsc();

  List<Star> findAllByOrderByHipAsc();

  List<Star> findAllByOrderByHdAsc();

  List<Star> findAllByOrderByHrAsc();

  List<Star> findAllByOrderByProper();
}
