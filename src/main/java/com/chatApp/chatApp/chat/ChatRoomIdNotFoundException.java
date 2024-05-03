package com.chatApp.chatApp.chat;

public class ChatRoomIdNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChatRoomIdNotFoundException(String message) {
        super(message);
    }
}
