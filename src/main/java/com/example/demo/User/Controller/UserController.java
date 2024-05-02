package com.example.demo.User.Controller;

import com.example.demo.User.DTO.UserCreateDTO;
import com.example.demo.User.DTO.UserDTO;
import com.example.demo.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserDTO> getAllUser() {
        return this.userService.getAllUser();
    }

    @PostMapping("/add")
    public UserDTO create(@RequestBody UserCreateDTO dto){
        return this.userService.create(dto);
    }

}


