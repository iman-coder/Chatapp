package com.chatApp.chatApp.chat;

import java.util.Date;

import jakarta.persistence.Column;
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
	@Column
	private String senderId;
	@Column
	private String reciverId;
	@Column
	private String content;
	@Column
	private Date timeStamp;
}
