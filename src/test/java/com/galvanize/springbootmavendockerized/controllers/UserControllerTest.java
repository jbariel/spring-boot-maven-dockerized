package com.galvanize.springbootmavendockerized.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllUsersTest() {
        try {
            mockMvc.perform(get("/users/")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
                    .andExpect(jsonPath("$").isEmpty());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }
}