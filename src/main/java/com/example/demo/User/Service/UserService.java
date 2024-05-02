package com.example.demo.User.Service;

import com.example.demo.User.DTO.UserCreateDTO;
import com.example.demo.User.DTO.UserDTO;

import java.util.List;


public interface UserService {
    UserDTO create(UserCreateDTO dto);
    List<UserDTO> getAllUser();

}