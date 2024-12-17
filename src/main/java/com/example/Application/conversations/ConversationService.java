package com.example.Application.conversations;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {
    private ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository){
        this.conversationRepository = conversationRepository;
    }
    public List<Conversation> getConvos() {
        return conversationRepository.findAll();
    }
}
