package com.example.demoapp.employees;

import com.example.demoapp.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable String id) {
        // Validate Input
        // Cleaning date
        //Success
        EmployeeResponse response = employeeService.getById(Integer.parseInt(id));
        return response;
    }

    @GetMapping("/employees")
    public EmployeeResponse[] listEmployee() {
        EmployeeResponse employeeResponse01 = new EmployeeResponse();
        employeeResponse01.setId(1);
        employeeResponse01.setName("Garun");
        EmployeeResponse employeeResponse02 = new EmployeeResponse();
        employeeResponse02.setId(2);
        employeeResponse02.setName("TestName");
        return new EmployeeResponse[]{employeeResponse01, employeeResponse02};
    }
}
