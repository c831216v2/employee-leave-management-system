package com.example.EmployeeLeaveManagementSystem.controller;

import com.example.EmployeeLeaveManagementSystem.entity.Leave;
import com.example.EmployeeLeaveManagementSystem.entity.User;
import com.example.EmployeeLeaveManagementSystem.repository.LeaveRepository;
import com.example.EmployeeLeaveManagementSystem.repository.UserRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final LeaveRepository leaveRepository;

    public AdminController(
            UserRepository userRepository,
            LeaveRepository leaveRepository) {

        this.userRepository = userRepository;
        this.leaveRepository = leaveRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/leaves")
    public List<Leave> getAllLeaves() {

        return leaveRepository.findAll();
    }
}
