package com.backend.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.config.JwtService;
import com.backend.dto.LoginRequest;
import com.backend.dto.LoginResponse;
import com.backend.entity.Department;
import com.backend.repository.DepartmentRepository;

@Component
public class DepartmentAuthProvider implements AuthProvider {

    private final DepartmentRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public DepartmentAuthProvider(
            DepartmentRepository repository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public boolean supports(String role) {
        return "DEPARTMENT".equalsIgnoreCase(role);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Department department = repository
                .findByDepartmentId(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("Department not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                department.getPassword()
        )) {
            throw new RuntimeException("Invalid Password");
        }

        Map<String, Object> claims = new HashMap<>();

        claims.put("id", department.getDepartmentId());
        claims.put("name", department.getDepartmentName());
        claims.put("email", department.getEmail());

        String token = jwtService.generateToken(
                department.getDepartmentId(),
                "DEPARTMENT",
                claims
        );

        return new LoginResponse(
                token,
                "DEPARTMENT",
                department.getDepartmentId(),
                department.getDepartmentName()
        );
    }
}