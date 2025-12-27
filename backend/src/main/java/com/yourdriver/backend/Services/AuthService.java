package com.yourdriver.backend.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yourdriver.backend.dtos.RegistrationRequest;
import com.yourdriver.backend.models.User;
import com.yourdriver.backend.repositories.UserRepository;
import com.yourdriver.backend.dtos.LoginRequest;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public void register(RegistrationRequest request) {

        if (userRepository.existsByEmail(request.email)) {
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

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password, user.getPassWord())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getEmail(), user.getRole() );
    }

}
