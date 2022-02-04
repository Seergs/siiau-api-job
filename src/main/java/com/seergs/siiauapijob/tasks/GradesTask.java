package com.seergs.siiauapijob.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class GradesTask extends ScheduledTask {
  @Autowired
  public GradesTask(RestTemplateBuilder restTemplateBuilder) {
    super.restTemplate = restTemplateBuilder.build();
  }

  @Value("${rest.api.grades.path}")
  public void setPath(String path) {
    super.path = path;
  }

  @Value("${rest.api.grades.method}")
  public void setMethod(String method) {
    super.method = method;
  }
}
