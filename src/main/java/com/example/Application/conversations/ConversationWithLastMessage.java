package com.example.Application.conversations;

import com.example.Application.message.Message;
import com.example.Application.user.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class ConversationWithLastMessage {
    private Long conversationId;
    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;
    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;
    private String lastMessageText;
    private LocalDateTime lastMessageSentAt;

    public ConversationWithLastMessage(Conversation conversation, Message lastMessage) {
        this.conversationId = conversation.getId();
        this.user1 = conversation.getUser1();
        this.user2 = conversation.getUser2();
        this.lastMessageText = (lastMessage != null) ? lastMessage.getContent() : "";
        this.lastMessageSentAt = (lastMessage != null) ? lastMessage.getSentAt() : null;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1Id(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2Id(User user2) {
        this.user2 = user2;
    }

    public String getLastMessageText() {
        return lastMessageText;
    }

    public void setLastMessageText(String lastMessageText) {
        this.lastMessageText = lastMessageText;
    }

    public LocalDateTime getLastMessageSentAt() {
        return lastMessageSentAt;
    }

    public void setLastMessageSentAt(LocalDateTime lastMessageSentAt) {
        this.lastMessageSentAt = lastMessageSentAt;
    }

    @Override
    public String toString() {
        return "ConversationWithLastMessage{" +
                "conversationId=" + conversationId +
                ", user1=" + user1 +
                ", user2=" + user2 +
                ", lastMessageText='" + lastMessageText + '\'' +
                ", lastMessageSentAt=" + lastMessageSentAt +
                '}';
    }
}
