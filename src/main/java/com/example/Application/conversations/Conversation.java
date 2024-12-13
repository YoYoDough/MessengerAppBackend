package com.example.Application.conversations;

import jakarta.persistence.*;

@Entity
@Table
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String message;

    public Conversation(){}

    public Conversation(Long id, Long senderId, Long receiverId, String message){
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
    }

    public Conversation(Long senderId, Long receiverId, String message){
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.message = message;
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

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", message='" + message + '\'' +
                '}';
    }
}
