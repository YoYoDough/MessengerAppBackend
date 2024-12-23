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

    private Long senderId;

    private String content;

    private LocalDateTime sentAt;

    public Message(){}

    public Message(Long id, Conversation conversation, Long senderId, String content, LocalDateTime sentAt){
        this.id = id;
        this.conversation = conversation;
        this.senderId = senderId;
        this.content = content;
        this.sentAt = sentAt;
    }

    public Message(Conversation conversation, Long senderId, String content, LocalDateTime sentAt){
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
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
