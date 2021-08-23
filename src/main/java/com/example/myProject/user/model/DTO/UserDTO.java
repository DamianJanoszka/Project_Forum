package com.example.myProject.user.model.DTO;

import com.example.myProject.user.model.entity.UserRole;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class UserDTO {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private UserRole userRole;
}
