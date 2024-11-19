package com.example.Application.friend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Table
@Entity
public class Friend {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long friend_id;

    private String status;

    public Friend(){}

    public Friend(Long id, Long user_id, Long friend_id, String status) {
        this.id = id;
        this.user_id = user_id;
        this.friend_id = friend_id;
        this.status = status;
    }

    public Friend(Long user_id, Long friend_id, String status){
        this.user_id = user_id;
        this.friend_id = friend_id;
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
        return friend_id;
    }

    public void setFriend_id(Long friend_id) {
        this.friend_id = friend_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", friend_id=" + friend_id +
                ", status='" + status + '\'' +
                '}';
    }
}
