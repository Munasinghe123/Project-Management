package com.yourdriver.backend.dtos;

import com.yourdriver.backend.enums.UserRole;

public class RegistrationRequest {

    public String fullName;
    public String userName;
    public String email;
    public String password;
    public UserRole role;
    
}
