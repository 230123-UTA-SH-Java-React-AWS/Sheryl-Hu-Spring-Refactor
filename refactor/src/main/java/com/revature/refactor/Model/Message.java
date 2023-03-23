package com.revature.refactor.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messageId;
    private int postedBy;
    @Column(length=255, nullable = false)
    private String messageText;
    private long timePostedEpoch;

    public Message() {
    }

    public Message(int messageId, int postedBy, String messageText,
                   long timePostedEpoch) {
        this.messageId = messageId;
        this.postedBy = postedBy;
        this.messageText = messageText;
        this.timePostedEpoch = timePostedEpoch;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(int postedBy) {
        this.postedBy = postedBy;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public long getTimePostedEpoch() {
        return timePostedEpoch;
    }

    public void setTimePostedEpoch(long timePostedEpoch) {
        this.timePostedEpoch = timePostedEpoch;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", postedBy=" + postedBy +
                ", messageText='" + messageText + '\'' +
                ", timePostedEpoch=" + timePostedEpoch +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageId == message.messageId && postedBy == message.postedBy && timePostedEpoch == message.timePostedEpoch && Objects.equals(messageText, message.messageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, postedBy, messageText, timePostedEpoch);
    }
}
