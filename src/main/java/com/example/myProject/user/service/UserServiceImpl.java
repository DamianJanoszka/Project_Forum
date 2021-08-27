package com.example.myProject.user.service;

import com.example.myProject.user.model.DTO.UserDTO;
import com.example.myProject.user.model.DTO.UserRoleDTO;
import com.example.myProject.user.model.entity.User;
import com.example.myProject.user.model.entity.UserRole;
import com.example.myProject.user.repository.UserRepository;
import com.example.myProject.user.repository.UserRoleRepository;
import com.example.myProject.user.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleServiceImpl userRoleServiceImpl;
    @Override
    public void createUser(UserDTO userDto, String password) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setPassword(password);
        UserRole userRole = userRoleServiceImpl.getUserRoleEntityById(userDto.getUserRole().getIdRole());
        user.setUserRole(userRole);
        userRepository.save(user);    }

    @Override
    public void updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.getById(userId);
        UserMapper.INSTANCE.updateUserFromDto(userDTO, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> all = userRepository.findAll();
        return UserMapper.INSTANCE.userListToUserDTOList(all);
    }

    @Override
    public UserDTO getById(Long userId) {
        return UserMapper.INSTANCE.userToUserDTO(userRepository.getById(userId));
    }
}
