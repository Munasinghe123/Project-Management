package com.projectmanagement.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanagement.backend.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

} 
    
