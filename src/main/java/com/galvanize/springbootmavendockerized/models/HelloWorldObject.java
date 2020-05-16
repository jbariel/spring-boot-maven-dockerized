package com.galvanize.springbootmavendockerized.models;

import java.io.Serializable;

public class HelloWorldObject implements Serializable {
    private static final long serialVersionUID = 1L;

    public HelloWorldObject() {
        super();
    }

    public HelloWorldObject(String name) {
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