package com.example.myProject.user.service;

import com.example.myProject.user.model.DTO.UserRoleDTO;
import com.example.myProject.user.model.entity.User;
import com.example.myProject.user.model.entity.UserRole;
import com.example.myProject.user.repository.UserRoleRepository;
import com.example.myProject.user.service.mapper.UserMapper;
import com.example.myProject.user.service.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public List<UserRoleDTO> getUserRoles() {
        List<UserRole> all = userRoleRepository.findAll();
        return UserRoleMapper.INSTANCE.userRoleListToUserRoleDTOList(all);
    }

    @Override
    public UserRoleDTO getById(Long id) {
        return UserRoleMapper.INSTANCE.userRoleToUserRoleDTO(userRoleRepository.getById(id));
    }
}
