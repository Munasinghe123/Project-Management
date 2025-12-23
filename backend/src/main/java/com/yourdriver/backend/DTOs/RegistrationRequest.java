package com.yourdriver.backend.DTOs;

import com.yourdriver.backend.Enums.UserRole;

public class RegistrationRequest {

    public String fullName;
    public String userName;
    public String email;
    public String password;
    public UserRole role;
    
}
