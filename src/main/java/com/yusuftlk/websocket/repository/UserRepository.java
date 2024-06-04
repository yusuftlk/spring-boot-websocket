package com.yusuftlk.websocket.repository;

import com.yusuftlk.websocket.model.Status;
import com.yusuftlk.websocket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAllByStatus(Status status);
}
