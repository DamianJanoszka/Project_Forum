package com.example.myProject.user.controller;

import com.example.myProject.user.model.DTO.UserDTO;
import com.example.myProject.user.model.entity.User;
import com.example.myProject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    UserService userRepo;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userRepo.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO>
    getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userRepo.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        userRepo.createUser(userDTO,"123");
        return new ResponseEntity<>("User is added successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object>
    updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        userRepo.updateUser(id, userDTO);
        return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        userRepo.deleteUser(id);
        return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
    }

}
