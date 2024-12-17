package com.example.Application.conversations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findByUser1IdAndUser2IdOrUser2IdAndUser1Id(Long user1Id, Long user2Id, Long user2IdReverse, Long user1IdReverse);

    List<Conversation> findByUser1_IdOrUser2_Id(Long user1Id, Long user2Id);
}
