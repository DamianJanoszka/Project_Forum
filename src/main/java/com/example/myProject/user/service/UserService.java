package com.example.myProject.user.service;

import com.example.myProject.user.model.entity.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void updateUser(Long user_id, User user);
    void deleteUser(Long user_id);
    List<User> getUsers();
    User getById(Long id);
}
