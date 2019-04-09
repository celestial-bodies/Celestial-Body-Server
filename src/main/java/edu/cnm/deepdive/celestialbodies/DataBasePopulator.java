package edu.cnm.deepdive.celestialbodies;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * Running Setup Data on Startup in Spring.  Calling not yet initialized fields will result in
 * NullPointerExceptions: this class manages this situation.  This class runs logic after the Spring
 * context has been initialized, waiting for all of them to initialize.
 *
 * In order to achieve this a bean that implements the ApplicationListener<ContextRefreshedEvent>
 * interface is implemented.
 */
@Component
public class DataBasePopulator implements
    ApplicationListener<ContextRefreshedEvent> {

  private SetupData setupData;

  /**
   * Receives {@link SetupData} for running setup data on startup.
   * @param setupData
   */
  public DataBasePopulator(SetupData setupData) {
    this.setupData = setupData;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    setupData.setupData();
  }







}
