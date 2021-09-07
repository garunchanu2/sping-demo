package com.example.demoapp;

import com.example.demoapp.employees.Employee;
import com.example.demoapp.employees.EmployeeRepository;
import com.example.demoapp.employees.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse getById(int id) {
//        EmployeeResponse employeeResponse01 = new EmployeeResponse();
//        employeeResponse01.setId(id);
//        employeeResponse01.setName("Garun");
        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isPresent()) {
            EmployeeResponse response = new EmployeeResponse();
            response.setId(result.get().getId());
            response.setName(result.get().getName());
            return response;
        }
        throw new RuntimeException("Employee not found id = " + id);
    }
}
