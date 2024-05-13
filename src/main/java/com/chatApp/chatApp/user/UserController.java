package com.chatApp.chatApp.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	 private final SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/user.addUser")
    //@SendTo("/user/{userId}/topic")
    public void addUser(@Payload User user) {
        userService.saveUser(user);
        //return user;
        messagingTemplate.convertAndSendToUser(user.getNickName().toString(), "/topic", user);
    }
	
	@MessageMapping("/user.disconnectUser")
    //@SendTo("/user/{userId}/topic")
    public void disconnectUser(@Payload User user) {
        userService.disconnect(user);
        //return user;
        messagingTemplate.convertAndSendToUser(user.getNickName().toString(), "/topic", user);
    }
	
	@GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
