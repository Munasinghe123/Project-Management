package com.projectmanagement.backend.dtos;

import com.projectmanagement.backend.enums.UserRole;

public class RegistrationRequest {

    public String fullName;
    public String userName;
    public String email;
    public String password;
    public UserRole role;
    
}
