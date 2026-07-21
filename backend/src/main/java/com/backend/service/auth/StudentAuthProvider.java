package com.backend.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.config.JwtService;
import com.backend.dto.LoginRequest;
import com.backend.dto.LoginResponse;
import com.backend.entity.Student;
import com.backend.repository.StudentRepository;

@Component
public class StudentAuthProvider implements AuthProvider {

    private final StudentRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public StudentAuthProvider(
            StudentRepository repository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public boolean supports(String role) {
        return "STUDENT".equalsIgnoreCase(role);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Student student = repository
                .findByStudentId(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                student.getPassword()
        )) {
            throw new RuntimeException("Invalid Password");
        }

        Map<String, Object> claims = new HashMap<>();

        claims.put("id", student.getStudentId());
        claims.put("name", student.getName());
        claims.put("email", student.getEmail());
        claims.put("departmentId", student.getDepartment().getDepartmentId());
        claims.put("passingYear", student.getPassingYear());

        String token = jwtService.generateToken(
                student.getStudentId(),
                "STUDENT",
                claims
        );

        return new LoginResponse(
                token,
                "STUDENT",
                student.getStudentId(),
                student.getName()
        );
    }
}