package com.seergs.siiauapijob.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public abstract class ScheduledTask {
  static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
  private final HttpHeaders headers = new HttpHeaders();
  private final List<String> credentials = Arrays.asList("personal", "alternative");
  protected String baseUrl;
  protected String path;
  protected String method;

  @Autowired
  private Environment env;

  protected RestTemplate restTemplate;

  @Value("${rest.baseUrl}")
  private void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public boolean execute() {
    String url = baseUrl + path;
    this.setPersonalCredentials();
    if(!this.isRequestSuccessful(url, HttpMethod.GET, new HttpEntity<>(headers))) {
      return false;
    }
    this.setAlternativeCredentials();
    return this.isRequestSuccessful(url, HttpMethod.GET, new HttpEntity<>(headers));
  }

  private boolean isRequestSuccessful(String url, HttpMethod method, HttpEntity<Void> request) {
    logger.info("Making a request to {} with method {}", url, method);
    ResponseEntity<Object> response =
            restTemplate.exchange(url, method, request, new ParameterizedTypeReference<>() {});
    if (response.getStatusCode() == HttpStatus.OK) {
      logger.info("Response is OK for {}", this.getClass().getSimpleName());
      return true;
    } else {
      logger.error("Response is not OK, please check the logs");
      return false;
    }
  }

  private void setPersonalCredentials() {
    String personalStudentCode = env.getProperty("rest.credentials.personal.studentCode");
    String personalStudentNip = env.getProperty("rest.credentials.personal.studentNip");
    headers.set("x-student-code", personalStudentCode);
    headers.set("x-student-nip", personalStudentNip);
  }

  private void setAlternativeCredentials() {
    String alternativeStudentCode = env.getProperty("rest.credentials.alternative.studentCode");
    String alternativeStudentNip = env.getProperty("rest.credentials.alternative.studentNip");
    headers.set("x-student-code", alternativeStudentCode);
    headers.set("x-student-nip", alternativeStudentNip);
  }
}
