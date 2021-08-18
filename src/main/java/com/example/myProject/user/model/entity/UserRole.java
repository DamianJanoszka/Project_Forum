package com.example.myProject.user.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users") // testing in progress..
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_role;

    private String role;

}
