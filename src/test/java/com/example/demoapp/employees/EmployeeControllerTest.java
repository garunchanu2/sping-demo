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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployeeById() {
        // Arrange
        int id = 1;
        Employee employee100 = new Employee();
        employee100.setName("Garun");
        employeeRepository.save(employee100);
        // Act
        EmployeeResponse result
                = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        // Assert
        assertEquals(id, result.getId());
        assertEquals("Garun", result.getName());
    }

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
        int id = 1;
        //Act
        EmployeeResponse result = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
        //Assert
        assertEquals(id, result.getId());
        assertEquals("Garun", result.getName());
    }
}