package com.chatApp.chatApp.chatRoom;

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
@Table(name="chatroom")
public class ChatRoom {
    @Id 
    private String id;
    @Column
    private String chatId;
    @Column
    private String senderId;
    @Column
    private String recipientId;
}
