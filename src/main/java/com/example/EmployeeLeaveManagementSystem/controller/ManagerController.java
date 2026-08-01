package com.example.EmployeeLeaveManagementSystem.controller;

import com.example.EmployeeLeaveManagementSystem.entity.Leave;
import com.example.EmployeeLeaveManagementSystem.entity.LeaveStatus;
import com.example.EmployeeLeaveManagementSystem.repository.LeaveRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    private final LeaveRepository leaveRepository;

    public ManagerController(
            LeaveRepository leaveRepository) {

        this.leaveRepository = leaveRepository;
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping("/leaves/{id}/approve")
    public String approveLeave(
            @PathVariable Long id) {

        Leave leave =
                leaveRepository.findById(id)
                        .orElseThrow();

        leave.setStatus(
                LeaveStatus.APPROVED
        );



        leaveRepository.save(leave);

        return "Leave approved successfully";
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping("/leaves/{id}/reject")
    public String rejectLeave(
            @PathVariable Long id) {

        Leave leave =
                leaveRepository.findById(id)
                        .orElseThrow();

        leave.setStatus(
                LeaveStatus.REJECTED
        );

        leaveRepository.save(leave);

        return "Leave rejected successfully";
    }
}