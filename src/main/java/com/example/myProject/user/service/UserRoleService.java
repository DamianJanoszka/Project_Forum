package com.example.myProject.user.service;

import com.example.myProject.user.model.DTO.UserRoleDTO;
import com.example.myProject.user.model.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRoleDTO> getUserRoles();
    UserRoleDTO getById(Long id);
    UserRole getUserRoleEntityById(Long id);
}
