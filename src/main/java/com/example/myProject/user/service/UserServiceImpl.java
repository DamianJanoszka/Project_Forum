package com.example.myProject.user.service;

import com.example.myProject.user.model.DTO.UserDTO;
import com.example.myProject.user.model.entity.User;
import com.example.myProject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void createUser(UserDTO userDto, String password) {
        User user = new User();
        user.setUserRole(userDto.getUserRole());
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setPassword(password);
        // id_role ustawic jakos
        userRepository.save(user);    }

    @Override
    public void updateUser(Long user_id, User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long user_id) {
        userRepository.deleteById(Math.toIntExact(user_id));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long user_id) {
        return userRepository.getById(Math.toIntExact(user_id));
    }
}
