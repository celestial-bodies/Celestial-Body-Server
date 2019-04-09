package edu.cnm.deepdive.celestialbodies.controller;

import edu.cnm.deepdive.celestialbodies.model.dao.StarRepository;
import edu.cnm.deepdive.celestialbodies.model.entity.Star;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Defines REST endpoints for servicing requests on {@link Star} resources, invoking {@link
 * StarRepository} methods to perform the required operations.
 */
@RestController
@ExposesResourceFor(StarController.class)
@RequestMapping("/stars")
public class StarController {

  private StarRepository starRepository;

  /**
   * Initializes this instance, injecting an instance of {@link StarRepository}
   *
   * @param starRepository repository used for operations on {@link Star} entity instances.
   */
  public StarController(StarRepository starRepository) {
    this.starRepository = starRepository;
  }

  /**
   * Returns a randomly selected {@link Star} resource, presumably for use in star information
   * retrieval-type applications.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Star> get() {
    return starRepository.findFirst10ByOrderByAbsmag();
  }

  //Add another method that returns one star based on id

}
