package com.example.Application.message;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderId;
    private String content;
    
    private Timestamp createdAt;

    public Message(){}

    public Message(Long id, Long senderId, String content, Timestamp createdAt){
        this.id = id;
        this.senderId = senderId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Message(Long senderId, String content, Timestamp createdAt){
        this.senderId =senderId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long sender_id) {
        this.senderId = sender_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender_id=" + senderId +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
