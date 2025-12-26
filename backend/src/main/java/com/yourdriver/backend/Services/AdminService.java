package com.yourdriver.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yourdriver.backend.models.User;
import com.yourdriver.backend.repositories.UserRepository;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
