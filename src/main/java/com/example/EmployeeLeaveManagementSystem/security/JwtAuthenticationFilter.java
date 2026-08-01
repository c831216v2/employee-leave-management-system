package com.example.EmployeeLeaveManagementSystem.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

            System.out.println("JWT FILTER RUNNING");
            String path = request.getServletPath();
            System.out.println("PATH = " + path);

            String authHeader = request.getHeader("Authorization");
            System.out.println("AUTH HEADER = " + authHeader);

        if (path.startsWith("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }


        if (authHeader != null &&
                authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);
            System.out.println("Token Received: " + token);

            try {

                String email = jwtService.extractEmail(token);
                System.out.println("Authenticated User: " + email);

                System.out.println(
                        "Authenticated User: " + email
                );

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                Collections.emptyList()
                        );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);



            } catch (Exception e) {

                response.setStatus(
                        HttpServletResponse.SC_UNAUTHORIZED
                );

                response.getWriter().write(
                        "Invalid JWT Token"
                );

                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}