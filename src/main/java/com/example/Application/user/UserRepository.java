package com.example.Application.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT r FROM User r WHERE r.email = ?1")
    Optional<User> findUserByEmail(String email);

    // Find a user by their username
    Optional<User> findByName(String name);
}
