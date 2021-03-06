package com.galvanize.springbootmavendockerized.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void canaryIsInTheCoalMineTest() {
        try {
            mockMvc.perform(get("/coal-mine")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string("Tweet"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void getJsonHelloObjectTest() {
        try {
            mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.value").value("Hello World!"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void getXmlHelloObjectTest() {
        try {
            mockMvc.perform(get("/hello").accept("application/xml")).andDo(print()).andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.xpath("//value").string(is("Hello World!")));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void getJsonHelloUserObjectTest() {
        try {
            mockMvc.perform(get("/hello/User")).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.value").value("Hello User!"));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void getXmlHelloUserObjectTest() {
        try {
            mockMvc.perform(get("/hello/User").accept("application/xml")).andDo(print()).andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.xpath("//value").string(is("Hello User!")));
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }
}