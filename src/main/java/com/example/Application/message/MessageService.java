package com.example.Application.message;

import com.example.Application.conversations.Conversation;
import com.example.Application.conversations.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessagesFromDatabase(){
        return messageRepository.findAll();
    }

    public void postMessages(Message message) {
        messageRepository.save(message);
    }

    public Message createMessage(Long conversationId, Long senderId, String input){
        Conversation conversation = conversationRepository.findById(conversationId).get();
        Message newMessage = new Message(conversation, senderId, input, LocalDateTime.now());
        return newMessage;
    }

    public List<Message> getMessagesWithConversationId(Long conversationId) {
        Conversation conversation = conversationRepository.findById(conversationId).get();
        List<Message> messages = messageRepository.findByConversation(conversation);
        System.out.println(messages.get(0));
        return messages;
    }
}
