package com.example.Application.friend;

import jakarta.persistence.*;

@Table
@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name  = "friend_id")
    private Long friendId;

    private String status;

    public Friend(){}

    public Friend(Long id, Long userId, Long friendId, String status) {
        this.id = id;
        this.userId = userId;
        this.friendId = friendId;
        this.status = status;
    }

    public Friend(Long userId, Long friendId, String status){
        this.userId = userId;
        this.friendId = friendId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getFriend_id() {
        return friendId;
    }

    public void setFriend_id(Long friendId) {
        this.friendId = friendId;
    }

    public Long getUser_id() {
        return userId;
    }

    public void setUser_id(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", user_id=" + userId +
                ", friend_id=" + friendId +
                ", status='" + status + '\'' +
                '}';
    }
}
