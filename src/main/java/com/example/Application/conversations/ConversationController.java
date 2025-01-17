package com.example.Application.conversations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/conversations")
public class ConversationController {
    private ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService){
        this.conversationService = conversationService;
    }

    @GetMapping
    public void getConversations(){
        System.out.println(conversationService.getConvos());
    }

    @PostMapping
    public ResponseEntity<?> insertConversation(@RequestBody ConversationRequest request){
        System.out.println(request.toString());
        Conversation conversation = conversationService.createOrGetConversation(request.getUser1Id(), request.getUser2Id());
        return ResponseEntity.ok(conversation);
    }

    @PostMapping("/getconvo")
    public ResponseEntity<?> getConversation(@RequestBody ConversationRequest request){
        System.out.println(request);
        Conversation conversation = conversationService.getConversation(request.getUser1Id(), request.getUser2Id());
        if (conversation == null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(conversation);
    }

    @GetMapping("/{selfId}")
    public ResponseEntity<?> getConversationsAttachedWithUser(@PathVariable String selfId){
        System.out.println("Self ID: " + selfId);
        Long id = Long.parseLong(selfId);
        List<ConversationWithLastMessage> conversations = conversationService.getUserConversations(id);
        return ResponseEntity.ok(conversations);
    }
}
