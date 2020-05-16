package com.galvanize.springbootmavendockerized.controllers;

import java.util.ArrayList;
import java.util.List;

import com.galvanize.springbootmavendockerized.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/")
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    @PutMapping("/")
    public User createUser(@RequestBody User user) {
        return user;
    }
}