package com.damu.shop.controllers;

import com.damu.shop.entities.Order;
import com.damu.shop.entities.User;
import com.damu.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getusers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("signup")
    public User signUp(@RequestBody User user){
        return userService.saveUser(user);
    }
}
