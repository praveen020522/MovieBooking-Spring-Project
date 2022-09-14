package com.SpringBoot.CrudDemo.rest;

import com.SpringBoot.CrudDemo.entity.User;
import com.SpringBoot.CrudDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/displayUser")
    public List<User> display(){
        return userService.displayUser();

    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);

    }

}
