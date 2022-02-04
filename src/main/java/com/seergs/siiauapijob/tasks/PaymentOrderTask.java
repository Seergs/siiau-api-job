package com.seergs.siiauapijob.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

@Component
public class PaymentOrderTask extends ScheduledTask {
  @Autowired
  public PaymentOrderTask(RestTemplateBuilder restTemplateBuilder) {
    super.restTemplate = restTemplateBuilder.build();
  }

  @Value("${rest.api.paymentorder.path}")
  public void setPath(String path) {
    super.path = path;
  }

  @Value("${rest.api.paymentorder.method}")
  public void setMethod(String method) {
    super.method = method;
  }
}
