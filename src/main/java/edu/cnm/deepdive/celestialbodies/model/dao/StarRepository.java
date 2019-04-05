package edu.cnm.deepdive.celestialbodies.model.dao;

import edu.cnm.deepdive.celestialbodies.model.entity.Star;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface StarRepository extends CrudRepository<Star, Long > {

    List<Star> findAllByOrderByIdAsc();

    List<Star> findAllByProperContainingOrderByIdAsc(String query);

}
