package edu.cnm.deepdive.celestialbodies.model.dao;

import edu.cnm.deepdive.celestialbodies.model.entity.Operator;
import edu.cnm.deepdive.celestialbodies.model.entity.OperatorQuery;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OperatorQueryRepository extends CrudRepository<OperatorQuery, Long> {

  List<OperatorQuery> findAllByOperatorOrderByCreatedDesc(Operator operator);


}
