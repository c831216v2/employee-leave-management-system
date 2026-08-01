package com.example.EmployeeLeaveManagementSystem.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.EmployeeLeaveManagementSystem.entity.User;
import com.example.EmployeeLeaveManagementSystem.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UserRepository userRepository) {

        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

            String path = request.getServletPath();
            String authHeader = request.getHeader("Authorization");

        if (path.startsWith("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            try {
                String email = jwtService.extractEmail(token);
                System.out.println(
                        "Authenticated User: " + email
                );

                Optional<User> userOptional = userRepository.findByEmail(email);

                if (userOptional.isEmpty()) {

                    response.setStatus(
                            HttpServletResponse.SC_UNAUTHORIZED
                    );

                    return;
                }

                User user = userOptional.get();
                System.out.println(
                        "ROLE = " + user.getRole()
                );

                List<SimpleGrantedAuthority> authorities =
                        List.of(
                                new SimpleGrantedAuthority(
                                        "ROLE_" + user.getRole().name()
                                )
                        );

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                authorities
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