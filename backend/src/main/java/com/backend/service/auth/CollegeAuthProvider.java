package com.backend.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.config.AdminProperties;
import com.backend.config.JwtService;
import com.backend.dto.LoginRequest;
import com.backend.dto.LoginResponse;

@Component
public class CollegeAuthProvider implements AuthProvider {

    private final AdminProperties adminProperties;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public CollegeAuthProvider(
            AdminProperties adminProperties,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.adminProperties = adminProperties;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public boolean supports(String role) {
        return "COLLEGE".equalsIgnoreCase(role);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        if (!adminProperties.getUsername().equals(request.getUsername())) {
            throw new RuntimeException("Invalid College Credentials");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                adminProperties.getPassword()
        )) {
            throw new RuntimeException("Invalid College Credentials");
        }

        Map<String, Object> claims = new HashMap<>();

        claims.put("id", "COLLEGE");
        claims.put("name", "College Admin");
        claims.put("email", adminProperties.getUsername());

        String token = jwtService.generateToken(
                adminProperties.getUsername(),
                "COLLEGE",
                claims
        );

        return new LoginResponse(
                token,
                "COLLEGE",
                "COLLEGE",
                "College Admin"
        );
    }
}