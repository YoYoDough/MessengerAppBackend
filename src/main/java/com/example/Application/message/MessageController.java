package com.example.Application.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void addMessages(@RequestBody Message message){
        messageService.postMessages(message);
    }


}
