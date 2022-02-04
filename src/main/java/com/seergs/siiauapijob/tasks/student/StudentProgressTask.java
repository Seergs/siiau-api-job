package com.seergs.siiauapijob.tasks.student;

import com.seergs.siiauapijob.tasks.ScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class StudentProgressTask extends ScheduledTask {
  @Autowired
  public StudentProgressTask(RestTemplateBuilder restTemplateBuilder) {
    super.restTemplate = restTemplateBuilder.build();
  }

  @Value("${rest.api.student.progress.path}")
  public void setPath(String path) {
    super.path = path;
  }

  @Value("${rest.api.student.progress.method}")
  public void setMethod(String method) {
    super.method = method;
  }
}
