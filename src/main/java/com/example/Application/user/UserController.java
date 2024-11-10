package com.example.Application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public void getUsers(){
        System.out.println(userService.getUsers());
    }

    @PostMapping
    public void addUsers(@RequestBody User user){
        userService.postUsers(user);
    }
}
