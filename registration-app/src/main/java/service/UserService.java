package com.example.registrationapp.service;

import com.example.registrationapp.entity.User;
import com.example.registrationapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        userRepository.findByEmail(user.getEmail()).ifPresent(existing -> {
            throw new RuntimeException("Email already registered");
        });
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}