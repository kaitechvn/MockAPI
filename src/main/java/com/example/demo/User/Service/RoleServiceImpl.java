package com.example.demo.User.Service;


import com.example.demo.User.DTO.RoleDTO;
import com.example.demo.User.Mapper.RoleMapper;
import com.example.demo.User.Model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    public static List<Role> roles = new ArrayList<>();
    private static Long ID = 1L;

    public RoleServiceImpl() {
    }

    @Override
    public RoleDTO create(RoleDTO dto) {
        Role role = RoleMapper.getInstance().toEntity(dto);
        Optional<Role> foundObject = roles.stream()
                .filter(obj -> obj.getName().equals(role.getName()))
                .findFirst();

        if (foundObject.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "We already have that role name ");
        } else {
            role.setId(ID++);
            roles.add(role);
            return RoleMapper.getInstance().toDTO(role);

        }
    }
}
