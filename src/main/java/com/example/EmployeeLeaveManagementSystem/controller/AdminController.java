package com.example.EmployeeLeaveManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class AdminController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/admin/test")
    public String adminTest() {

        return "Admin endpoint working";

    }
}