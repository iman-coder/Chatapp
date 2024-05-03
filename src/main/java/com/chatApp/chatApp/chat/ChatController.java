package com.chatApp.chatApp.chat;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
	private final SimpMessagingTemplate template;
	private final ChatMessageService service;
	
	@MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        ChatMessage savedMsg = service.save(chatMessage);
        // imane/queue/messages
        template.convertAndSendToUser(
                chatMessage.getReciverId(), "/queue/messages",
                new ChatNotification(
                        savedMsg.getChatId(),
                        savedMsg.getSenderId(),
                        savedMsg.getReciverId(),
                        savedMsg.getContent()
                )
        );
    }
	
	@MessageMapping("/messages/{senderId}/{recieverId}")
	public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable("senderId") String senderId, 
			@PathVariable("recieverId") String recieverId){
		return ResponseEntity.ok(service.findChatMessage(senderId, recieverId));
	}
	
}
