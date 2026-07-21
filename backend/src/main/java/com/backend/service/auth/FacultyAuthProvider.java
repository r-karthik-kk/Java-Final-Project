package com.backend.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.config.JwtService;
import com.backend.dto.LoginRequest;
import com.backend.dto.LoginResponse;
import com.backend.entity.Faculty;
import com.backend.repository.FacultyRepository;

@Component
public class FacultyAuthProvider implements AuthProvider {

    private final FacultyRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public FacultyAuthProvider(
            FacultyRepository repository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public boolean supports(String role) {
        return "FACULTY".equalsIgnoreCase(role);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Faculty faculty = repository
                .findByFacultyId(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("Faculty not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                faculty.getPassword()
        )) {
            throw new RuntimeException("Invalid Password");
        }

        Map<String, Object> claims = new HashMap<>();

        claims.put("id", faculty.getFacultyId());
        claims.put("name", faculty.getName());
        claims.put("email", faculty.getEmail());
        claims.put("departmentId", faculty.getDepartment().getDepartmentId());

        String token = jwtService.generateToken(
                faculty.getFacultyId(),
                "FACULTY",
                claims
        );

        return new LoginResponse(
                token,
                "FACULTY",
                faculty.getFacultyId(),
                faculty.getName()
        );
    }
}