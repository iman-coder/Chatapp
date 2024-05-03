package com.chatApp.chatApp.chatRoom;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, String>{
	Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
