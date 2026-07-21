package com.backend.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.config.JwtService;
import com.backend.dto.LoginRequest;
import com.backend.dto.LoginResponse;
import com.backend.entity.Client;
import com.backend.repository.ClientRepository;

@Component
public class ClientAuthProvider implements AuthProvider {

    private final ClientRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public ClientAuthProvider(
            ClientRepository repository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public boolean supports(String role) {
        return "CLIENT".equalsIgnoreCase(role);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Client client = repository
                .findByClientId(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("Client not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                client.getPassword()
        )) {
            throw new RuntimeException("Invalid Password");
        }

        Map<String, Object> claims = new HashMap<>();

        claims.put("id", client.getClientId());
        claims.put("name", client.getName());
        claims.put("email", client.getEmail());
        claims.put("type", client.getClientType().getTypeName());

        String token = jwtService.generateToken(
                client.getClientId(),
                "CLIENT",
                claims
        );

        return new LoginResponse(
                token,
                "CLIENT",
                client.getClientId(),
                client.getName()
        );
    }
}