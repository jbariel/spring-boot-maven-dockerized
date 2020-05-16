package com.galvanize.springbootmavendockerized.controllers;

import com.galvanize.springbootmavendockerized.models.HelloWorldObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping("coal-mine")
    public String canaryIsInTheCoalMine() {
        return "Tweet";
    }

    @GetMapping("hello")
    public HelloWorldObject getJsonHelloObject() {
        return new HelloWorldObject();
    }

    @GetMapping("hello/{user}")
    public HelloWorldObject getJsonHelloObject(@PathVariable String user) {
        return new HelloWorldObject(user);
    }

}