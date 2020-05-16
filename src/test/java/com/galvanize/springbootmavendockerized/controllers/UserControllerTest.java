package com.galvanize.springbootmavendockerized.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.galvanize.springbootmavendockerized.models.User;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new JsonMapper();

    @Test
    public void getAllUsersTest() {
        try {
            mockMvc.perform(get("/users/")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
                    .andExpect(jsonPath("$").isEmpty());

            mockMvc.perform(put("/users/").content(mapper.writeValueAsString(new User()))
                    .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.firstName").isEmpty());

            // mockMvc.perform(get("/users/")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
            // .andExpect(jsonPath("$").isNotEmpty());

        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }
}