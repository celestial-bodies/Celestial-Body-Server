package edu.cnm.deepdive.celestialbodies.model.dao;

import edu.cnm.deepdive.celestialbodies.model.entity.Operator;
import edu.cnm.deepdive.celestialbodies.model.entity.OperatorQuery;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface declares methods by which data in the OperatorQuery entity will be accessed.
 */

public interface OperatorQueryRepository extends CrudRepository<OperatorQuery, Long> {

  List<OperatorQuery> findAllByOperatorOrderByCreatedDesc(Operator operator);
>>>>>>> origin/Ryan
}
