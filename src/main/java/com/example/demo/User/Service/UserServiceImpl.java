package com.example.demo.User.Service;
import org.apache.commons.lang3.RandomStringUtils;

import com.example.demo.User.DTO.UserCreateDTO;
import com.example.demo.User.DTO.UserDTO;
import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.Model.Role;
import com.example.demo.User.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.demo.User.Service.RoleServiceImpl.roles;


@Service
public class UserServiceImpl implements UserService {
    TreeMap<String, User> users;

    public UserServiceImpl() {
        users = new TreeMap<>();
    }

    private String generateRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    @Override
    public List<UserDTO> getAllUser() {
        if (users.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "We dont have any users");
        } else {
            List<UserDTO> dtoUsers = new ArrayList<>();
            for (Map.Entry<String, User> entry : users.entrySet()) {
                User value = entry.getValue();
                dtoUsers.add(UserMapper.getInstance().toDTO(value));
            }
            return dtoUsers;
        }
    }

    @Override
    public UserDTO create(UserCreateDTO dto) {
        User user = UserMapper.getInstance().toEnity(dto);
        List<Role> roleOfUser = roles.stream()
                .filter(obj -> dto.getRoleIds().contains(obj.getId()))
                .collect(Collectors.toList());

        if (roleOfUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "We dont have this role id");
        } else {
            user.setRoles(roleOfUser);
            user.setUserId(generateRandomString(10));
            users.put(user.getUserId(), user);
            return UserMapper.getInstance().toDTO(user);
        }
    }
}



