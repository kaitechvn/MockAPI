package com.example.demo.User.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDTO {
    private String username;
    @Positive
    private Integer age;
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    private List<Long> roleIds;





}
