package com.yourdriver.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourdriver.backend.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByEmail(String email);
}
