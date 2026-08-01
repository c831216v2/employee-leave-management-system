package com.example.EmployeeLeaveManagementSystem.repository;

import com.example.EmployeeLeaveManagementSystem.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

    List<Leave> findByEmployeeEmail(String employeeEmail);

}