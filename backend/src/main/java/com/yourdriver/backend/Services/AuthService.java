package com.yourdriver.backend.Services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yourdriver.backend.DTOs.RegistrationRequest;
import com.yourdriver.backend.Models.User;
import com.yourdriver.backend.Repositories.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Transactional
    public void register(RegistrationRequest request){

        if(userRepository.existsByEmail(request.email)){
            throw new RuntimeException("email already exixts");
        }

        User user = new User();

        user.setFullName(request.fullName);
        user.setUserName(request.userName);
        user.setEmail(request.email);
        user.setPassWord(passwordEncoder.encode(request.password));
        user.setRole(request.role);

        userRepository.save(user);
    }
    
}
