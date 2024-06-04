package com.yusuftlk.websocket.controller;

import com.yusuftlk.websocket.model.User;
import com.yusuftlk.websocket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @MessageMapping("/user.addUser")
    @SendTo("/topic/topic")
    public User saveUser(@Payload User user) {
        return userService.saveUser(user);
    }
    @MessageMapping("/user.disconnectUser")
    @SendTo("/topic/topic")
    public User disconnect(@Payload User user){
        return userService.disconnect(user);
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> findConnectedUsers(){
        return ResponseEntity.ok(userService.findConnectedUsers());
    }





}
