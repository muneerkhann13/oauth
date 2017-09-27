package com.asce.oauth.controllers;

import com.asce.oauth.common.health.response.HealthResponse;
import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.GitProperties;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  private final GitProperties gitProperties;

  @Value("${application.name}")
  private  String applicationName;

  @Value("${build.version}")
  private   String buildVersion;

  @Value("${build.time}")
  private  String timestamp;
  @Inject
  HealthController(GitProperties gitProperties){
    this.gitProperties = gitProperties;
  }

  @GetMapping("/ping")
  public HealthResponse ping(){
    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
    Timestamp startedTime =  Timestamp.valueOf(timestamp);
    long duration = currentTime.getTime() - startedTime.getTime();

    HealthResponse healthResponse = new HealthResponse();
    healthResponse.setApplicationName(applicationName);
    healthResponse.setHealth("Application is Healthy");
    healthResponse.setDuration(duration);
    healthResponse.setStartTime(timestamp);
    healthResponse.setVersion(buildVersion);

    return healthResponse;
  }

}
