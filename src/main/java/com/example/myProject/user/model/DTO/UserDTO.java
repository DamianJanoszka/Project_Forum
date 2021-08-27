package com.example.myProject.user.model.DTO;

import com.example.myProject.user.model.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private UserRoleDTO userRole;
}
