package com.example.EmployeeLeaveManagementSystem.controller;

import com.example.EmployeeLeaveManagementSystem.dto.LeaveRequest;
import com.example.EmployeeLeaveManagementSystem.entity.Leave;
import com.example.EmployeeLeaveManagementSystem.entity.LeaveStatus;
import com.example.EmployeeLeaveManagementSystem.repository.LeaveRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveRepository leaveRepository;

    public LeaveController(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping
    public String submitLeave(
            @RequestBody LeaveRequest request,
            Authentication authentication) {

        Leave leave = new Leave();

        leave.setEmployeeEmail(authentication.getName());
        leave.setStartDate(request.getStartDate());
        leave.setEndDate(request.getEndDate());
        leave.setReason(request.getReason());
        leave.setStatus(LeaveStatus.PENDING);
        leave.setCreatedAt(LocalDateTime.now());
        leaveRepository.save(leave);

        return "Leave request submitted successfully";
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/my")
    public List<Leave> getMyLeaves(
            Authentication authentication) {

        return leaveRepository.findByEmployeeEmail(
                authentication.getName()
        );
    }

}