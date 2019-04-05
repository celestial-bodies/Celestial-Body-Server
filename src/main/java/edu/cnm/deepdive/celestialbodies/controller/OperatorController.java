package edu.cnm.deepdive.celestialbodies.controller;


import edu.cnm.deepdive.celestialbodies.model.dao.OperatorRepository;
import edu.cnm.deepdive.celestialbodies.model.entity.Operator;
import edu.cnm.deepdive.celestialbodies.model.entity.Star;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Defines REST endpoints for servicing requests on {@link Operator} resources, invoking {@link
 * OperatorRepository} methods to perform the required operations.
 */
@RestController
@ExposesResourceFor(Operator.class)
@RequestMapping("/quotes")
public class QuoteController {

  private OperatorRepository quoteRepository;
  private SourceRepository sourceRepository;

  /**
   * Initializes this instance, injecting an instance of {@link QuoteRepository} and an instance of
   * {@link SourceRepository}.
   *
   * @param quoteRepository repository used for operations on {@link Operator} entity instances.
   * @param sourceRepository repository used for operations on {@link Star} entity instances.
   */
  @Autowired
  public QuoteController(QuoteRepository quoteRepository, SourceRepository sourceRepository) {
    this.quoteRepository = quoteRepository;
    this.sourceRepository = sourceRepository;
  }

  /**
   * Returns a randomly selected {@link Operator} resource, presumably for use in "Quote of the
   * Day"-type applications.
   *
   * @return random {@link Operator}.
   */
  @GetMapping(value = "random", produces = MediaType.APPLICATION_JSON_VALUE)
  public Operator getRandom() {
    return quoteRepository.findRandom().get();
  }

  /**
   * Returns a sequence of {@link Operator} resources, containing the specified text.
   *
   * @param fragment text to match (case-insensitive).
   * @return sequence of {@link Operator} resources.
   */
  @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Operator> search(@RequestParam("q") String fragment) {
    return quoteRepository.findAllByTextContainingOrderByTextAsc(fragment);
  }

  /**
   * Returns a sequence of all the {@link Operator} resources in the database.
   *
   * @return sequence of {@link Operator} resources.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Operator> get() {
    return quoteRepository.findAllByOrderByTextAsc();
  }

  /**
   * Adds the provided {@link Operator} resource to the database and returns the completed resource,
   * including timestamp &amp; ID. The provided resource is only required to contain a
   * <code>text</code> property, with a non-<code>null</code> value.
   *
   * @param quote partial {@link Operator} resource.
   * @return completed {@link Operator} resource.
   */
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Operator> post(@RequestBody Operator quote) {
    quoteRepository.save(quote);
    return ResponseEntity.created(quote.getHref()).body(quote);
  }

  /**
   * Retrieves and returns the {@link Operator} resource with the specified ID.
   *
   * @param quoteId quote {@link UUID}.
   * @return retrieved {@link Operator} resource.
   */
  @GetMapping(value = "{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Operator get(@PathVariable("quoteId") UUID quoteId) {
    return quoteRepository.findById(quoteId).get();
  }

  /**
   * Replaces the text (which is the only consumer-specifiable property) of the referenced existing
   * {@link Operator} resource with the text from the provided resource.
   *
   * @param quoteId source {@link UUID}.
   * @param update {@link Operator} resource to use to replace contents of existing quote.
   */
  @PutMapping(value = "{quoteId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void put(@PathVariable("quoteId") UUID quoteId, @RequestBody Operator update) {
    Operator quote = quoteRepository.findById(quoteId).get();
    quote.setText(update.getText());
    quoteRepository.save(quote);
  }

  /**
   * Deletes the specified {@link Operator} resource from the database.
   *
   * @param quoteId quote {@link UUID}.
   */
  @DeleteMapping(value = "{quoteId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("quoteId") UUID quoteId) {
    quoteRepository.delete(get(quoteId));
  }

  /**
   * Associates the {@link Star} specified in the request body with the {@link Operator} referenced
   * by the path parameter. Only the <code>id</code> property of the {@link Star} must be
   * specified.
   *
   * @param quoteId {@link UUID} of {@link Operator} resource.
   * @param source {@link Star} to be associated with referenced {@link Operator}.
   * @return updated {@link Operator} resource.
   */
  @PostMapping(value = "{quoteId}/sources",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Operator attach(@PathVariable("quoteId") UUID quoteId, @RequestBody Star source) {
    return attach(quoteId, source.getId());
  }

  /**
   * Associates the {@link Star} referenced in the path with the {@link Operator}, also referenced by
   * a path parameter.
   *
   * @param quoteId {@link UUID} of {@link Operator} resource.
   * @param sourceId {@link UUID} of {@link Star} to be associated with referenced {@link Operator}.
   * @return updated {@link Operator} resource.
   */
  @PutMapping(value = "{quoteId}/sources/{sourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Operator attach(@PathVariable("quoteId") UUID quoteId, @PathVariable UUID sourceId) {
    Star source = sourceRepository.findById(sourceId).get();
    Operator quote = get(quoteId);
    quote.getSources().add(source);
    quoteRepository.save(quote);
    return quote;
  }

  /**
   * Retrieves and returns the referenced {@link Star} resource associated with the referenced
   * {@link Operator} resource. If either does not exist, or if the referenced source is not associated
   * with the quote, this method will fail.
   *
   * @param quoteId {@link UUID} of {@link Operator} resource.
   * @param sourceId {@link UUID} of {@link Star} associated with referenced {@link Operator}.
   * @return referenced {@link Star} resource.
   */
  @GetMapping(value = "{quoteId}/sources/{sourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Star get(
      @PathVariable("quoteId") UUID quoteId, @PathVariable("sourceId") UUID sourceId) {
    Operator quote = get(quoteId);
    Star source = sourceRepository.findById(sourceId).get();
    if (!quote.getStar().contains(source)) {
      throw new NoSuchElementException();
    }
    return source;
  }

  /**
   * Removes the association between the referenced {@link Operator} resource and the referenced
   * {@link Star} resource. If either does not exist, or if the referenced source is not
   * associated with the quote, this method will fail.
   *
   * @param quoteId {@link UUID} of {@link Operator} resource.
   * @param sourceId {@link UUID} of {@link Star} to be disassociated from referenced {@link
   * Operator}.
   */
  @DeleteMapping(value = "{quoteId}/sources/{sourceId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void detach(
      @PathVariable("quoteId") UUID quoteId, @PathVariable("sourceId") UUID sourceId) {
    Operator quote = get(quoteId);
    Star source = get(quoteId, sourceId);
    quote.getSources().remove(source);
    quoteRepository.save(quote);
  }

  /**
   * Maps (via annotation) a {@link NoSuchElementException} to a response status code of {@link
   * HttpStatus#NOT_FOUND}.
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {}

}
