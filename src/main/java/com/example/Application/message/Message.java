package com.example.Application.message;

import com.example.Application.conversations.Conversation;
import com.example.Application.user.User;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Instant;

@Table
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    private Long senderId;

    private String content;

    private Instant sentAt;

    public Message(){}

    public Message(Long id, Conversation conversation, Long senderId, String content, Instant sentAt){
        this.id = id;
        this.conversation = conversation;
        this.senderId = senderId;
        this.content = content;
        this.sentAt = sentAt;
    }

    public Message(Conversation conversation, Long senderId, String content, Instant sentAt){
        this.conversation = conversation;
        this.senderId = senderId;
        this.content = content;
        this.sentAt = sentAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getSentAt() {
        return sentAt;
    }

    public void setSentAt(Instant sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", conversation=" + conversation +
                ", content='" + content + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }
}
