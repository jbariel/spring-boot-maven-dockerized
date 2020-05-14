package com.galvanize.springbootmavendockerized;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping("coal-mine")
    public String canaryIsInTheCoalMine() {
        return "Tweet";
    }
}