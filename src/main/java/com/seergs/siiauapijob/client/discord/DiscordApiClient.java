package com.seergs.siiauapijob.client.discord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DiscordApiClient {
    private static final Logger logger = LoggerFactory.getLogger(DiscordApiClient.class);
    private static final String ERROR_IN_DISCORD_MESSAGE = "Error while sending Discord message";

    private String webhookUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public DiscordApiClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

   @Value("${discord.webhook.url}")
   private void setWebhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
   }

    public void postMessage(final DiscordPostMessage message) {
        try {
            logger.info("Sending message to Discord: {}", message.getContent());
            final HttpEntity<DiscordPostMessage> request = new HttpEntity<>(message);
            this.restTemplate.postForObject(webhookUrl, request, String.class);
        } catch(Exception e) {
            logger.error(ERROR_IN_DISCORD_MESSAGE, e);
            throw new RuntimeException(ERROR_IN_DISCORD_MESSAGE, e);
        }
    }
}
