package com.example.myProject.user.service.mapper;

import com.example.myProject.user.model.DTO.UserRoleDTO;
import com.example.myProject.user.model.entity.UserRole;
import org.mapstruct.factory.Mappers;

public interface UserRoleMapper {

    UserRoleMapper INSTANCE = Mappers.getMapper( UserRoleMapper.class );
    UserRoleDTO UserRoleToUserRoleDTO(UserRole userRole);
}
