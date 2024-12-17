package com.example.Application.message;

import com.example.Application.conversations.Conversation;
import com.example.Application.user.User;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    private String content;

    private LocalDateTime createdAt;

    public Message(){}

    public Message(Long id, Conversation conversation, User sender, String content, LocalDateTime createdAt){
        this.id = id;
        this.conversation = conversation;
        this.sender = sender;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public Message(Conversation conversation, User sender, String content, LocalDateTime createdAt){
        this.conversation = conversation;
        this.sender =sender;
        this.content = content;
        this.createdAt = createdAt;
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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", conversation=" + conversation +
                ", sender=" + sender +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
