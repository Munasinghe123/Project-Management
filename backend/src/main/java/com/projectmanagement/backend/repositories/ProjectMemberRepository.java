package com.projectmanagement.backend.repositories;

import com.projectmanagement.backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
    boolean existsByProjectAndUser(Project project, User user);
}
