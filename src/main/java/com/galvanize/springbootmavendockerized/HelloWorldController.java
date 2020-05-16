package com.galvanize.springbootmavendockerized;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
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

    @GetMapping("hello")
    public TmpObject getJsonHelloObject() {
        return new TmpObject();
    }

    class TmpObject implements Serializable {
        private static final long serialVersionUID = 1L;

        private String value = "Hello World!";

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}