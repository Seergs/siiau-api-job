package com.seergs.siiauapijob.tasks.student;

import com.seergs.siiauapijob.tasks.ScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class StudentTask extends ScheduledTask {
  @Autowired
  public StudentTask(RestTemplateBuilder restTemplateBuilder) {
    super.restTemplate = restTemplateBuilder.build();
  }

  @Value("${rest.api.student.general.path}")
  public void setPath(String path) {
    super.path = path;
  }

  @Value("${rest.api.student.general.method}")
  public void setMethod(String method) {
    super.method = method;
  }
}
