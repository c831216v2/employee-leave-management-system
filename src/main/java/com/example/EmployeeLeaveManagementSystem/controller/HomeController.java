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
                            background: #f4f6f9;
                            margin: 0;
                            padding: 40px;
                        }

                        .container {
                            max-width: 1200px;
                            margin: auto;
                        }

                        h1 {
                            color: #2c3e50;
                        }

                        .subtitle {
                            color: #666;
                            margin-bottom: 30px;
                        }

                        .grid {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
                            gap: 20px;
                        }

                        .card {
                            background: white;
                            padding: 20px;
                            border-radius: 12px;
                            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
                        }

                        .card h3 {
                            margin-top: 0;
                            color: #0078d4;
                        }

                        .button {
                            display: inline-block;
                            margin-top: 10px;
                            background: #0078d4;
                            color: white;
                            text-decoration: none;
                            padding: 10px 16px;
                            border-radius: 6px;
                        }

                        .button:hover {
                            background: #005ea6;
                        }

                        .status {
                            color: green;
                            font-weight: bold;
                            margin-bottom: 20px;
                        }

                        .footer {
                            margin-top: 40px;
                            color: #777;
                        }

                        code {
                            background: #eee;
                            padding: 2px 6px;
                            border-radius: 4px;
                        }
                    </style>
                </head>

                <body>

                <div class="container">

                    <h1>Employee Leave Management System</h1>

                    <p class="status">✅ Application Online</p>

                    <p class="subtitle">
                        Spring Boot • PostgreSQL • JWT Authentication • RBAC • Swagger • Render
                    </p>

                    <div class="grid">

                        <div class="card">
                            <h3>Swagger API Documentation</h3>
                            <p>Explore and test every endpoint in the system.</p>

                            /swagger-ui/index.html
                               Open Swagger
                            </a>
                        </div>

                        <div class="card">
                            <h3>User Registration</h3>
                            <p>Create Employee, Manager and Admin accounts.</p>

                            swagger-ui/index.html"
                               target="_blank">
                               Register User
                            </a>
                        </div>

                        <div class="card">
                            <h3>JWT Authentication</h3>
                            <p>Login and generate a JWT access token.</p>

                            /swagger-ui/index.html
                               Login
                            </a>
                        </div>

                        <div class="card">
                            <h3>Leave Management</h3>
                            <p>Submit leave requests and track status.</p>

                            /swagger-ui/index.html target="_blank">
                               Submit Leave
                            </a>
                        </div>

                        <div class="card">
                            <h3>Manager Workflow</h3>
                            <p>Approve and reject employee leave requests.</p>

                            /swagger-ui/index.html
                               Manager Functions
                            </a>
                        </div>

                        <div class="card">
                            <h3>Admin Portal</h3>
                            <p>View users and all leave requests.</p>

                            /index.html"
                               target="_blank">
                               Admin Functions
                            </a>
                        </div>

                        <div class="card">
                            <h3>GitHub Repository</h3>
                            <p>Explore the full source code.</p>

                            https://github.com/c831216v2/employee-leave-management-system
                        </div>

                        <div class="card">
                            <h3>Quick Start Guide</h3>

                            <p>
                                1. Open Swagger<br>
                                2. Register User<br>
                                3. Login<br>
                                4. Copy JWT Token<br>
                                5. Test Protected APIs
                            </p>
                        </div>

                    </div>

                    <div class="footer">
                        <p>
                            Built using Spring Boot, PostgreSQL,
                            Spring Security, JWT, Role-Based Access Control,
                            Swagger/OpenAPI and Render Deployment.
                        </p>
                    </div>

                </div>

                </body>
                </html>
                """;
    }
}