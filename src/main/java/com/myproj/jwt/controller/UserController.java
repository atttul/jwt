package com.myproj.jwt.controller;

import com.myproj.jwt.entity.User;
import com.myproj.jwt.response.FinalResponse;
import com.myproj.jwt.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
    @GetMapping("/{user}")
    public FinalResponse someRandomAPI(@PathVariable String user){
        return userService.someRandomAPI(user);
    }
    @GetMapping("/user")
    public String getUser() {
        return "User controller Get";
    }
}
