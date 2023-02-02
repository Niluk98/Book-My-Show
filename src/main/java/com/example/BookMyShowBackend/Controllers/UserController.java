package com.example.BookMyShowBackend.Controllers;


import com.example.BookMyShowBackend.DTO.UserRequestDTO;
import com.example.BookMyShowBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody()UserRequestDTO userRequestDTO){
     return userService.createUser(userRequestDTO);
    }
}
