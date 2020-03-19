package com.example.messageboard;

import java.io.Serializable;

public class Message implements Serializable {
    private boolean isAnonymous;
    private String name;
    private String topic;
    private String detail;

    public Message (boolean isAnonymous, String name, String topic, String detail){
        this.isAnonymous = isAnonymous;
        if (isAnonymous) this.name = "Anonymous User";
        else this.name = name;
        this.topic = topic;
        this.detail = detail;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
