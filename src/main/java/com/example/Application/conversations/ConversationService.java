package com.example.Application.conversations;

import java.util.List;

public class ConversationService {
    private ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository){
        this.conversationRepository = conversationRepository;
    }
    public List<Conversation> getConvos() {
        return conversationRepository.findAll();
    }
}
