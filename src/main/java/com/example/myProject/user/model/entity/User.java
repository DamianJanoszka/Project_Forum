package com.example.myProject.user.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role") // nullable = false
    private UserRole userRole;

}
