package com.example.Application.message;

public class MessageRequest {
    private Long conversationId;
    private Long senderId;
    private String input;

    public MessageRequest(Long conversationId, Long senderId, String input){
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.input = input;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "conversationId=" + conversationId +
                ", senderId=" + senderId +
                ", input='" + input + '\'' +
                '}';
    }
}
