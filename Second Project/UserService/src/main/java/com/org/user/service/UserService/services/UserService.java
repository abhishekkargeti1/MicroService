package com.org.user.service.UserService.services;

import com.org.user.service.UserService.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDTO  createUser(UserDTO user);

    List<UserDTO> getAllUserDetails();


    UserDTO getUserDetailsById(UUID id);


    UserDTO updateUserDetails(UserDTO details);

    String deteleUserDetails(UUID id);


}
