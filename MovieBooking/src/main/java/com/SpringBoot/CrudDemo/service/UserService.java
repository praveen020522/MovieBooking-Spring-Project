package com.SpringBoot.CrudDemo.service;

import com.SpringBoot.CrudDemo.Repo.UserRepo;
import com.SpringBoot.CrudDemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> displayUser(){
        return userRepo.findAll();
    }

    public User getByUserName(String user){
        return userRepo.findByUserName(user);
    }

    public User getById(int user) {
        return userRepo.findById(user).get();

    }
}
