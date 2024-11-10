package com.example.Application.user;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

@Table
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    private String password;

    private String image;

    public User(){}

    public User(Long id, String username, String email, String password, String image){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.image = image;
    }

    public User(String username, String email, String password, String image){
        this.username = username;
        this.email = email;
        this.password = password;
        this.image = image;
    }
}
