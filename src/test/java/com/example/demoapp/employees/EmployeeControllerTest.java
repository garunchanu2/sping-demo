package com.example.demoapp.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listEmployee() {
        //Act
        EmployeeResponse[] responses = restTemplate.getForObject("/employees", EmployeeResponse[].class);

        //Assert
        assertEquals(2, responses.length);
        assertEquals(1, responses[0].getId());
        assertEquals("Garun", responses[0].getName());
    }
}