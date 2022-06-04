package com.example.project3.service;

import com.example.project3.model.User;
import com.example.project3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUser(Integer user_id) {
        return userRepository.findById(user_id);
    }
}
