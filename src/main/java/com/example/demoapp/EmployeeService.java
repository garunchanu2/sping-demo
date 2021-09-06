package com.example.demoapp;

import com.example.demoapp.employees.EmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public EmployeeResponse getById(int id) {
        EmployeeResponse employeeResponse01 = new EmployeeResponse();
        employeeResponse01.setId(id);
        employeeResponse01.setName("Garun");
        return employeeResponse01;
    }
}
