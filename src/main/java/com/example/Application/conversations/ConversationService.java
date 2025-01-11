package com.example.Application.conversations;

import com.example.Application.message.Message;
import com.example.Application.message.MessageRepository;
import com.example.Application.user.User;
import com.example.Application.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConversationService {
    private ConversationRepository conversationRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public ConversationService(ConversationRepository conversationRepository){
        this.conversationRepository = conversationRepository;
    }
    public List<Conversation> getConvos() {
        return conversationRepository.findAll();
    }

    public void postConvos(Conversation conversation){
        conversationRepository.save(conversation);
    }

    public Conversation createOrGetConversation(Long user1Id, Long user2Id) {
        Optional<Conversation> existingConversation = conversationRepository.findByUser1IdAndUser2IdOrUser2IdAndUser1Id(user1Id, user2Id, user1Id, user2Id);
        if (existingConversation.isPresent()){
            return existingConversation.get();
        }

        User user1 = userRepository.findById(user1Id).orElseThrow(() -> new IllegalArgumentException("User 1 Not Found!"));
        User user2 = userRepository.findById(user2Id).orElseThrow(() -> new IllegalArgumentException("User 2 Not Found!"));

        Conversation newConversation = new Conversation();
        newConversation.setUser1(user1);
        newConversation.setUser2(user2);
        newConversation.setCreatedAt(LocalDateTime.now());
        return conversationRepository.save(newConversation);
    }

    public List<ConversationWithLastMessage> getUserConversations(Long selfId) {
        List<Conversation> conversations = conversationRepository.findAllByUser1IdOrUser2Id(selfId, selfId);
        return conversations.stream().map(conversation -> {
            Message lastMessage = messageRepository.findTopByConversationOrderBySentAtDesc(conversation);
            return new ConversationWithLastMessage(conversation, lastMessage);
        }).toList();
    }

    public Conversation getConversation(Long user1Id, Long user2Id) {
        return conversationRepository.findByUser1IdAndUser2Id(user1Id, user2Id);
    }
}
