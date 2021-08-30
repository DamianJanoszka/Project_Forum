package com.example.myProject.user.controller;

import com.example.myProject.user.model.DTO.UserDTO;
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
    UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO>
    getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO,"123");
        return new ResponseEntity<>("User is added successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String>
    updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
    }

}
