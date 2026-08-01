package com.example.EmployeeLeaveManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class ManagerController {

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/api/manager/test")
    public String managerTest() {

        return "Manager endpoint working";

    }
}