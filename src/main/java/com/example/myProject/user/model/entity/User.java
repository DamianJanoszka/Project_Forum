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
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)//@JoinColumn(name="users_id") //testing in progress...
    private UserRole userRole;

}
