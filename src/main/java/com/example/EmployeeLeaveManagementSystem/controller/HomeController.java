package com.example.EmployeeLeaveManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {

        return """
            Employee Leave Management System API

            Swagger:
            /swagger-ui/index.html

            API Status: ONLINE
            """;
    }
}