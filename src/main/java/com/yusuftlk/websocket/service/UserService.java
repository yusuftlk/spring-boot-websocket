package com.yusuftlk.websocket.service;

import com.yusuftlk.websocket.model.Status;
import com.yusuftlk.websocket.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.yusuftlk.websocket.model.User;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user) {
        user.setStatus(Status.ONLINE);
        return userRepository.save(user);
    }

    public User disconnect(User user){
        var storedUser = userRepository.findById(user.getNickName()).orElse(null);
        if(storedUser != null){
            storedUser.setStatus(Status.OFFLINE);
            return userRepository.save(storedUser);
        }
        return null;
    }
    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }


}
