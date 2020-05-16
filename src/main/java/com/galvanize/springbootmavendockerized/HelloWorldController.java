package com.galvanize.springbootmavendockerized;

import java.io.Serializable;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
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
    public TmpObject getJsonHelloObject() {
        return new TmpObject();
    }

    @GetMapping("hello/{user}")
    public TmpObject getJsonHelloObject(@PathVariable String user) {
        return new TmpObject(user);
    }

    class TmpObject implements Serializable {
        private static final long serialVersionUID = 1L;

        public TmpObject() {
            super();
        }

        public TmpObject(String name) {
            this();
            this.name = name;
        }

        private String value = "Hello %s!";

        private String name = "World";

        public String getValue() {
            return String.format(value, name);
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}