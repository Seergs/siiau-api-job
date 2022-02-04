package com.seergs.siiauapijob.client.discord;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscordPostMessage {
    @JsonProperty("content")
    private String content;

    public DiscordPostMessage() {}

    public DiscordPostMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
