package com.galvanize.springbootmavendockerized.controllers;

import java.util.ArrayList;
import java.util.List;

import com.galvanize.springbootmavendockerized.entities.UserRepository;
import com.galvanize.springbootmavendockerized.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PutMapping("/")
    public User createUser(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }
}