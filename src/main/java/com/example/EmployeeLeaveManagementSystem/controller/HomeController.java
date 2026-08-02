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
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            margin: 0;
                        }

                        .container {
                            background: white;
                            padding: 40px;
                            border-radius: 12px;
                            text-align: center;
                            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
                            max-width: 700px;
                        }

                        h1 {
                            color: #2c3e50;
                        }

                        p {
                            color: #555;
                        }

                        .button {
                            display: inline-block;
                            margin-top: 20px;
                            padding: 12px 24px;
                            background-color: #0078d4;
                            color: white;
                            text-decoration: none;
                            border-radius: 6px;
                            font-weight: bold;
                        }

                        .button:hover {
                            background-color: #005ea6;
                        }
                    </style>
                </head>
                <body>

                    <div class="container">

                        <h1>Employee Leave Management System</h1>

                        <p>
                            Spring Boot • PostgreSQL • JWT Authentication •
                            Role-Based Access Control • Swagger • Render
                        </p>

                        <p>
                            ✅ Application Online
                        </p>

                        /swagger-ui/index.html
                            Open API Documentation
                        </a>

                    </div>

                </body>
                </html>
                """;
    }
}