package com.projectmanagement.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectmanagement.backend.models.User;
import com.projectmanagement.backend.repositories.UserRepository;

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
