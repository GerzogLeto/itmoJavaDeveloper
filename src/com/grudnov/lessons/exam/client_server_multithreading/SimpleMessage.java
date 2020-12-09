package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SimpleMessage implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;
    private String thread;

    public SimpleMessage(String sender, String text, String thread) {
        this.sender = sender;
        this.text = text;
        this.thread = thread;
    }

    public String getThread() {
        return thread;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime() {
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "thread: " + this.thread + "\n" +
                "time: " + this.dateTime + "\n" +
                "sender: " + this.sender + "\n" +
                "text: " + this.text + "\n";
    }

    public static SimpleMessage getMessage(String sender, String text, String thread) {
        return new SimpleMessage(sender, text, thread);
    }
}