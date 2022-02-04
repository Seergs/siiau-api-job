package com.seergs.siiauapijob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SiiauApiJobApplication {

  public static void main(String[] args) {
    SpringApplication.run(SiiauApiJobApplication.class, args);
  }
}
