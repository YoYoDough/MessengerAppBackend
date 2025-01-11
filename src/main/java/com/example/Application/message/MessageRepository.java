package com.example.Application.message;

import com.example.Application.conversations.Conversation;
import com.example.Application.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findTopByConversationOrderBySentAtDesc(Conversation conversation);

    List<Message> findByConversation(Conversation conversation);
}
