package com.example.Application.friend;

import com.example.Application.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    @Query("SELECT f.friendId FROM Friend f WHERE f.userId = :userId")
    List<Long> findFriendIdsByUserId(@Param("userId") Long userId);
}
