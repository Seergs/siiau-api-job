package com.seergs.siiauapijob;

import com.seergs.siiauapijob.client.discord.DiscordApiClient;
import com.seergs.siiauapijob.client.discord.DiscordPostMessage;
import com.seergs.siiauapijob.tasks.*;
import com.seergs.siiauapijob.tasks.student.StudentLoginTask;
import com.seergs.siiauapijob.tasks.student.StudentProgressTask;
import com.seergs.siiauapijob.tasks.student.StudentTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {
  private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

  private final List<ScheduledTask> tasks = new ArrayList<>();
  private final DiscordApiClient discordApiClient;

  @Autowired
  public ScheduledTasks(
      AdmissionTask admissionTask,
      StudentTask studentTask,
      StudentProgressTask studentProgressTask,
      StudentLoginTask studentLoginTask,
      GradesTask gradesTask,
      CreditsTask creditsTask,
      ScheduleTask scheduleTask,
      PaymentOrderTask paymentOrderTask,
      DiscordApiClient discordApiClient) {
    this.tasks.addAll(
        List.of(
            admissionTask,
            studentTask,
            studentProgressTask,
            studentLoginTask,
            gradesTask,
            creditsTask,
            scheduleTask,
            paymentOrderTask));
    this.discordApiClient = discordApiClient;
  }

  @Scheduled(fixedRate = 1000 * 60 * 60 * 24)
  public void runScheduledTasks() {
    logger.info("Running all scheduled tasks");
    List<Boolean> results = new ArrayList<>();

    for (ScheduledTask task : tasks) {
      results.add(task.execute());
    }

    logger.info("Finished running all scheduled tasks");

    if (results.stream().anyMatch(result -> !result)) {
      this.discordApiClient.postMessage(
          new DiscordPostMessage("@everyone Siiau API job failed for some tasks"));
    }
  }
}
