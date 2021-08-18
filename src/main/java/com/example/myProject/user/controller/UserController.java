package com.example.myProject.user.controller;

import com.example.myProject.user.model.entity.User;
import com.example.myProject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController{
    @Autowired
    UserRepository userRepository;


    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/employees")
    User createOrSaveEmployee(@RequestBody User user) {
        return userRepository.save(user);
    }

}
