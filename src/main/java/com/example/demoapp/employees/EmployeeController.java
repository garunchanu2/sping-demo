package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

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
