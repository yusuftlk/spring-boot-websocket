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
    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnect(User user) {
        var storedUser = userRepository.findById(user.getNickName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers() {

        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
