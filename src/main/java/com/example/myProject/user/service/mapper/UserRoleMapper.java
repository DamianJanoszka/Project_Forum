package com.example.myProject.user.service.mapper;

import com.example.myProject.user.model.DTO.UserRoleDTO;
import com.example.myProject.user.model.entity.UserRole;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface UserRoleMapper {

    UserRoleMapper INSTANCE = Mappers.getMapper( UserRoleMapper.class );
    void updateUserRoleFromDto(UserRoleDTO userRoleDTO, @MappingTarget UserRole userRole);
    UserRoleDTO userRoleToUserRoleDTO(UserRole userRole);
    List<UserRoleDTO> userRoleListToUserRoleDTOList(List<UserRole> userRoleList);
}
