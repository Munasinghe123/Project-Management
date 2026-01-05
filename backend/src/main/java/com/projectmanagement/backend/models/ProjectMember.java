package com.projectmanagement.backend.models;

import com.projectmanagement.backend.enums.ProjectRole;
import jakarta.persistence.*;

@Entity
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    @Enumerated(EnumType.STRING)
    private ProjectRole role;
}
