package com.example.myProject.user.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users") // testing in progress..
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_role;

    private String role;

    @OneToMany
    private Set<User> users;
}
