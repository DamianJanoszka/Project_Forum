package com.example.myProject.user.service.mapper;

import com.example.myProject.user.model.DTO.UserDTO;
import com.example.myProject.user.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    @Mapping(source="user.userRole", target="userRole")
    UserDTO userToUserDTO(User user);
    void updateUserFromDto(UserDTO userDTO, @MappingTarget User user);
    List<UserDTO> userListToUserDTOList(List<User> commonUsers);
}
