package com.egreenfoxacademy.groot;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.json.JSONObject;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GuardianControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void GETresponseGrootServiceSendsStatusAndParameter() throws Exception{

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","Hello");

        mockMvc.perform(get("/groot")
                .content(String.valueOf(jsonObject))
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.received",is("Hello")))
                .andExpect(jsonPath("$.translated",is("I am Groot!"))
                );

    }

    @Test
    public void GETresponseGrootServiceSendsStatusNoParameter() throws Exception{

        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("message",null);

        mockMvc.perform(get("/groot")
                        .content(String.valueOf(jsonObject))
                        .contentType("application/json"))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.error",is("I am Groot!"))
                );

    }

}
