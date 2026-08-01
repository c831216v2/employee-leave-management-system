package com.example.EmployeeLeaveManagementSystem.controller;

import com.example.EmployeeLeaveManagementSystem.entity.User;
import com.example.EmployeeLeaveManagementSystem.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.EmployeeLeaveManagementSystem.dto.LoginRequest;
import java.util.Optional;
import com.example.EmployeeLeaveManagementSystem.security.JwtService;
import com.example.EmployeeLeaveManagementSystem.dto.LoginResponse;
import com.example.EmployeeLeaveManagementSystem.security.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Optional<User> userOptional =
                userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            return "User not found";
        }

        User user = userOptional.get();

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            return "Invalid password";
        }

        String token =
                jwtService.generateToken(user.getEmail());

        return token;
    }
}
