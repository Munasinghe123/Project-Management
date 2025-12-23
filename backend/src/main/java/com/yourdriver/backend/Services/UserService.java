package com.yourdriver.backend.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yourdriver.backend.Repositories.UserRepository;
import com.yourdriver.backend.Models.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
