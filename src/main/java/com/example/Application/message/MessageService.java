package com.example.Application.message;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessagesFromDatabase(){
        return messageRepository.findAll();
    }

    public void postMessages(Message message) {
        messageRepository.save(message);
    }
}
