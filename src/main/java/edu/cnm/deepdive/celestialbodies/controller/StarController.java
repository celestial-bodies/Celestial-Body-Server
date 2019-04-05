package edu.cnm.deepdive.celestialbodies.controller;

import edu.cnm.deepdive.celestialbodies.model.dao.StarRepository;
import edu.cnm.deepdive.celestialbodies.model.entity.Star;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(StarController.class)
@RequestMapping("/stars")
public class StarController {

  private StarRepository starRepository;

  public StarController(StarRepository starRepository) {
    this.starRepository = starRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Star> get() {
    return starRepository.findFirst10ByOrderByAbsmag();
  }

  //Add another method that returns one star based on id

}
