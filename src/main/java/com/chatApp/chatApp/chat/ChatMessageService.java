package com.chatApp.chatApp.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chatApp.chatApp.chatRoom.ChatRoomService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
	private final ChatMessageRepository repository;
	private final ChatRoomService service;
	
	public ChatMessage save(ChatMessage chatmessage) {
		var chatId = service.getChatRoomId(chatmessage.getSenderId(), chatmessage.getReciverId(), true)
				.orElseThrow(() -> new ChatRoomIdNotFoundException("Chat room ID not found"));
		chatmessage.setChatId(chatId);
		repository.save(chatmessage);
		return chatmessage;
	}
	public List<ChatMessage> findChatMessage(String senderId, String reciverId){
		var chatId = service.getChatRoomId(senderId, reciverId, false);
		return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
	}
}
