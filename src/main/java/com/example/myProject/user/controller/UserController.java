package com.example.myProject.user.controller;

import com.example.myProject.user.model.entity.User;
import com.example.myProject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userRepo;


    @GetMapping(value = "/users")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userRepo.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createOrSaveUser(@RequestBody User user) {
        userRepo.createUser(user);
        return new ResponseEntity<>("User is added successfully", HttpStatus.CREATED);
    }

    @PostMapping(value = "/users/{id}")
    public ResponseEntity<Object>
    updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userRepo.updateUser(id, user);
        return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        userRepo.deleteUser(id);
        return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
    }

}
