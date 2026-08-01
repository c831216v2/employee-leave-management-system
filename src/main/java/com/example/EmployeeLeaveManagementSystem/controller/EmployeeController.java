package com.example.EmployeeLeaveManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class EmployeeController {

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/api/employee/test")
    public String employeeTest() {

        return "Employee endpoint working";

    }
}