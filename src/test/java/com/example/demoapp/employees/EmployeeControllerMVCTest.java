package com.example.demoapp.employees;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerMVCTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getEmployeeById() throws Exception {
        int id = 1;
        MvcResult result = mvc.perform(get("/employees/" + id))
                .andExpect(status().isOk())
                .andReturn();
        // Response Body
        byte[] json = result.getResponse().getContentAsByteArray();
        ObjectMapper mapper = new ObjectMapper();
        EmployeeResponse respones = mapper.readValue(json, EmployeeResponse.class);
        //Assert
        assertEquals(id, respones.getId());
        assertEquals("Garun", respones.getName());
    }


}