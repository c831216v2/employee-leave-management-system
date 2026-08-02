package com.example.EmployeeLeaveManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = "text/html")
    public String home() {

        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Employee Leave Management System</title>

                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #f4f6f9;
                            padding: 40px;
                            margin: 0;
                        }

                        h1 {
                            color: #2c3e50;
                        }

                        .container {
                            max-width: 1000px;
                            margin: auto;
                        }

                        .grid {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                            gap: 20px;
                            margin-top: 30px;
                        }

                        .card {
                            background: white;
                            padding: 20px;
                            border-radius: 10px;
                            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
                        }

                        .card h3 {
                            margin-top: 0;
                        }

                        .button {
                            display: inline-block;
                            margin-top: 10px;
                            padding: 10px 15px;
                            background: #0078d4;
                            color: white;
                            text-decoration: none;
                            border-radius: 5px;
                        }

                        .button:hover {
                            background: #005ea6;
                        }

                        .status {
                            color: green;
                            font-weight: bold;
                        }
                    </style>
                </head>

                <body>
                    <div class="container">

                        <h1>Employee Leave Management System</h1>

                        <p class="status">✅ API Online</p>

                        <p>
                            Spring Boot • PostgreSQL • JWT Authentication • RBAC • Swagger • Render
                        </p>

                        <div class="grid">

                            <div class="card">
                                <h3>Swagger Documentation</h3>
                                <p>View and test all API endpoints.</p>
                                /swagger-ui/index.html
                            </div>

                            <div class="card">
                                <h3>Register User</h3>
                                <p>Create a new employee, manager or admin account.</p>
                                /swagger-ui/index.html#/auth-controller
                                   Open
                                </a>
                            </div>

                            <div class="card">
                                <h3>Login</h3>
                                <p>Generate a JWT token.</p>
                                #/auth-controller"
                                   target="_blank">
                                   Open
                                </a>
                            </div>

                            <div class="card">
                                <h3>Submit Leave</h3>
                                <p>Create a leave request.</p>
                                swagger-ui/index.html#/leave-controller"
                                   target="_blank">
                                   Open
                                </a>
                            </div>

                            <div class="card">
                                <h3>My Leave Requests</h3>
                                <p>View submitted leave requests.</p>
                                /swagger-ui/index.html#/leave-controller
                                   Open
                                </a>
                            </div>

                            <div class="card">
                                <h3>Manager Approval</h3>
                                <p>Approve or reject leave requests.</p>
                                /swagger-ui/index.html#/manager-controller                                   target="_blank">
                                   Open
                                </a>
                            </div>

                            <div class="card">
                                <h3>Admin Functions</h3>
                                <p>Manage users and view all leave requests.</p>
                                /swagger-ui/index.html#/admin-controller>
                            </div>

                            <div class="card">
                                <h3>GitHub Repository</h3>
                                <p>View source code and project documentation.</p>
                                v2/employee-leave-management-system"
                                   target="_blank">
                                   Open GitHub
                                </a>
                            </div>

                        </div>

                    </div>
                </body>
                </html>
                """;
    }
}