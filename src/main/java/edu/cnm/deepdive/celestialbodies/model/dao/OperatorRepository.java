package edu.cnm.deepdive.celestialbodies.model.dao;

import edu.cnm.deepdive.celestialbodies.model.entity.Operator;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface declares methods by which data in the Operator entity will be
 * accessed.
 */

public interface OperatorRepository extends CrudRepository<Operator, Long> {



  /**
   * Declares database operations that can be performed on {@link Quote} entity instances.
   */

    /**
     * Selects and returns all {@link Operator} instances, sorted in alphabetical order.
     *
     * @return {@link Iterable} sequence of {@link Operator} instances.
     */
    //Iterable<Operator> findAllByOrderByTextAsc();

    /**
     * Selects and returns all {@link Operator} instances containing the specified text fragment, in
     * alphabetical order.
     *
     * @param fragment filter text content.
     * @return {@link Iterable} sequence of {@link Operator} instances.
     */
    //Iterable<Operator> findAllByTextContainingOrderByTextAsc(String fragment);

    /**
     * Selects and returns a randomly selected {@link Operator} instance. Note that this is currently
     * implemented with Derby-specific SQL, since there is not a JPQL-standard way of sorting on a
     * random value (i.e. shuffling), nor of limiting the number of rows returned.
     *
     * @return random {@link Operator} instance.
     */
    @Query(value = "SELECT * FROM sa.quote ORDER BY RANDOM() OFFSET 0 ROWS FETCH NEXT 1 ROW ONLY",
        nativeQuery = true)
    Optional<Operator> findRandom();

  }




