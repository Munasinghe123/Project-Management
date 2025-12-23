package com.yourdriver.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourdriver.backend.DTOs.RegistrationRequest;
import com.yourdriver.backend.Services.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegistrationRequest request) {
       
        authService.register(request);
        return ResponseEntity.ok("user registered successfully");
    }
    
}
