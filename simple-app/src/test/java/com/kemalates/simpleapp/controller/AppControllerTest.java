package com.kemalates.simpleapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AppController.class)
@AutoConfigureMockMvc
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    String sampleJson =
            "{ \"foo\" : \"bar\", \"demo\" : \"app\" }";

    @Test
    void whenValidUrlAndMethodAndContentType_thenReturns200() throws Exception {

        mockMvc.perform(post("/api/v1/echo")
                        .content(sampleJson)
                        .contentType("application/json"))
                .andExpect(status().isOk());

    }


    @Test
    void whenEmpty_thenReturns400() throws Exception {

        mockMvc.perform(post("/api/v1/echo")
                        .content("")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }
}
