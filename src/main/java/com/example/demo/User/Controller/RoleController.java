package com.example.demo.User.Controller;

import com.example.demo.User.DTO.RoleDTO;
import com.example.demo.User.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public RoleDTO create(@RequestBody RoleDTO dto) {
        return this.roleService.create(dto);
    }
}
