package com.egreenfoxacademy.groot;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class YonduControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void GETresponseGrootServiceSendsStatusAndParameter() throws Exception{

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("distance","100");
        jsonObject.put("time","10");

        mockMvc.perform(get("/yondu")
                        .content(String.valueOf(jsonObject))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.distance",is(100.0)))
                .andExpect(jsonPath("$.time",is(10.0)))
                .andExpect(jsonPath("$.speed",is(10.0))
                );
    }

    @Test
    public void GETresponseGrootServiceSendsStatusNoParameter() throws Exception{

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("distance","100");
        jsonObject.put("time","0");

        mockMvc.perform(get("/yondu")
                        .content(String.valueOf(jsonObject))
                        .contentType("application/json"))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.error",is("No parameter or invalid time"))
                );
    }
}

