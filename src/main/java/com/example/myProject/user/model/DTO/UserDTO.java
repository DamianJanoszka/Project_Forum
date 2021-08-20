package com.example.myProject.user.model.DTO;

import com.example.myProject.user.model.entity.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private String login;
    private UserRole userRole;
}
