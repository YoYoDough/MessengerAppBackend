package com.example.Application.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/messages")
@CrossOrigin("http://localhost:3000")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping
    public void getMessages(){

        System.out.println(messageService.getMessagesFromDatabase());
    }

    @PostMapping
    public void addMessages(@RequestBody MessageRequest messageRequest){
        System.out.println(messageRequest);
        Message message = messageService.createMessage(messageRequest.getConversationId(), messageRequest.getSenderId(), messageRequest.getInput());
        messageService.postMessages(message);
    }

    @GetMapping("withconvo")
    public ResponseEntity<?> getMessagesAttachedToConvo(@RequestParam Long conversationid){
        List<Message> messages = messageService.getMessagesWithConversationId(conversationid);
        return ResponseEntity.ok(messages);
    }
}
