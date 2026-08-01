package com.example.EmployeeLeaveManagementSystem;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMethodSecurity
public class EmployeeLeaveManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeLeaveManagementSystemApplication.class, args);
	}

}
