package com.org.user.service.UserService.mapper;

import com.org.user.service.UserService.dto.UserDTO;
import com.org.user.service.UserService.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserEntity getEntity(UserDTO details) {
        UserEntity entity = new UserEntity();
        entity.setName(details.getName());
        entity.setEmail(details.getEmail());
        entity.setPassword(details.getPassword());
        entity.setAbout(details.getAbout());
        return entity;
    }

    public static UserDTO getDTO(UserEntity details) {
        UserDTO dto = new UserDTO();
        dto.setId(details.getId());
        dto.setName(details.getName());
        dto.setEmail(details.getEmail());
        dto.setAbout(details.getAbout());
        return dto;

    }

    public static List<UserDTO> getDTOList(List<UserEntity> list) {
        List<UserDTO> convertedDetails = new ArrayList<>();
        for (UserEntity details : list) {
        UserDTO dto = new UserDTO();
            dto.setId(details.getId());
            dto.setName(details.getName());
            dto.setEmail(details.getEmail());
            dto.setAbout(details.getAbout());
            convertedDetails.add(dto);
        }
        return convertedDetails;
    }
}
