package com.seergs.siiauapijob.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class AdmissionTask extends ScheduledTask {

  @Autowired
  public AdmissionTask(RestTemplateBuilder restTemplateBuilder) {
    super.restTemplate = restTemplateBuilder.build();
  }

  @Value("${rest.api.admission.path}")
  public void setPath(String path) {
    super.path = path;
  }

  @Value("${rest.api.admission.method}")
  public void setMethod(String method) {
    super.method = method;
  }
}
