package com.example.demo.User.Mapper;

import com.example.demo.User.DTO.RoleDTO;
import com.example.demo.User.Model.Role;


public class RoleMapper {
    private static RoleMapper instance;

    public static RoleMapper getInstance() {
        if (instance == null) {
            instance = new RoleMapper();
        }
        return instance;
    }

        public Role toEntity(RoleDTO roleDTO) {
            Role role = new Role();
            role.setName(roleDTO.getName().toLowerCase());
            return role;
        }
        public RoleDTO toDTO(Role role) {
            RoleDTO dto = new RoleDTO();
            dto.setName(role.getName());
            dto.setId(role.getId());
            return dto;
        }
    }

