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
        EmployeeResponse[] result = restTemplate.getForObject("/employees", EmployeeResponse[].class);
        //Assert
        assertEquals(2, result.length);
        assertEquals(1, result[0].getId());
        assertEquals("Garun", result[0].getName());
    }

    @Test
    public void EmployeeById(){
        //Act
        EmployeeResponse result = restTemplate.getForObject("/employees/1", EmployeeResponse.class);
        //Assert
        assertEquals(1, result.getId());
        assertEquals("Garun", result.getName());
    }
}