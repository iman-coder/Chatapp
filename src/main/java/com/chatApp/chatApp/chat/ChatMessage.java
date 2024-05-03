package com.chatApp.chatApp.chat;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="chatmessage")
public class ChatMessage {
	@Id 
	private String chatId;
	private String senderId;
	private String reciverId;
	private String content;
	private Date timeStamp;
}
