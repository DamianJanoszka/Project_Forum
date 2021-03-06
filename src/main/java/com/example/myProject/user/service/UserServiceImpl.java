package com.example.myProject.user.service;

import com.example.myProject.user.model.DTO.UserDTO;
import com.example.myProject.user.model.entity.MyUserDetails;
import com.example.myProject.user.model.entity.User;
import com.example.myProject.user.model.entity.UserRole;
import com.example.myProject.user.repository.UserRepository;
import com.example.myProject.user.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleServiceImpl userRoleServiceImpl;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserDTO userDto, String password) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(password));
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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(userName);

        if(user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(user);
    }
}
