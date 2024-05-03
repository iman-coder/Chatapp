package com.chatApp.chatApp.chat;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {
	private String chatId;
    private String senderId;
    private String recipientId;
    private String content;
}
