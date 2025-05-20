package com.example.Application.conversations;

import com.example.Application.user.User;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    private Instant createdAt;

    public Conversation(){}

    public Conversation(Long id, User user1, User user2){
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.createdAt = Instant.now();
    }

    public Conversation(User user1, User user2){
        this.user1 = user1;
        this.user2 = user2;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", user1=" + user1 +
                ", user2=" + user2 +
                ", createdAt=" + createdAt +
                '}';
    }
}
