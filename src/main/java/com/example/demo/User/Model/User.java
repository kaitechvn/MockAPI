package com.example.demo.User.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String userId;
    private String username;
    private String passord;
    private Integer age;

    private List<Role> roles;

}
