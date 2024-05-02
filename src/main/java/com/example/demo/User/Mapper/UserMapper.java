package com.example.demo.User.Mapper;

import com.example.demo.User.DTO.UserCreateDTO;
import com.example.demo.User.Model.User;
import com.example.demo.User.DTO.UserDTO;


import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {

    private static UserMapper instance;

    public static UserMapper getInstance() {
        if (instance == null) {
            instance = new UserMapper();
        }
        return instance;
    }

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setAge(user.getAge());
        dto.setRoles(user.getRoles().stream()
                .map(role -> RoleMapper.getInstance().toDTO(role))
                .collect(Collectors.toList()));
        return dto;
    }

    public User toEnity(UserCreateDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassord(dto.getPassword());
        user.setAge(dto.getAge());
        return user;
    }

}
