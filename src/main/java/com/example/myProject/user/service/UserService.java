package com.example.myProject.user.service;

import com.example.myProject.user.model.DTO.UserDTO;
import com.example.myProject.user.model.entity.User;

import java.util.List;

public interface UserService {
    void createUser(UserDTO user, String password);
    void updateUser(Long userId, UserDTO userdto);
    void deleteUser(Long userId);
    List<UserDTO> getUsers();
    UserDTO getById(Long id);
}
