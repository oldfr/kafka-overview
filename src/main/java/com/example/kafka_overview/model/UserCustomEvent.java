package com.example.kafka_overview.model;

public class UserCustomEvent {
    private String userId;
    private String eventType;

    public UserCustomEvent() {
    }

    public UserCustomEvent(String userId, String eventType) {
        this.userId = userId;
        this.eventType = eventType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "userId='" + userId + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
