package com.amitech.springcommonservice.demos.java.designPatterns.creational.factory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResource {
    String platform;
    String message;
    @JsonProperty("chat_name")
    String chatName;

    @JsonProperty("game_id")
    int gameId;

    boolean record;

    public MessageResource() {
    }

    public MessageResource(String platform, String message, String chatName, int gameId, boolean record) {
        this.platform = platform;
        this.message = message;
        this.chatName = chatName;
        this.gameId = gameId;
        this.record = record;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public boolean isRecord() {
        return record;
    }

    public void setRecord(boolean record) {
        this.record = record;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "MessageResource{" +
                "platform='" + platform + '\'' +
                ", message='" + message + '\'' +
                ", chatName='" + chatName + '\'' +
                ", gameId=" + gameId +
                ", record=" + record +
                '}';
    }
}
