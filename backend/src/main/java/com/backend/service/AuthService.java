package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.dto.LoginRequest;
import com.backend.dto.LoginResponse;
import com.backend.service.auth.AuthProvider;

@Service
public class AuthService {

    private final List<AuthProvider> providers;

    public AuthService(List<AuthProvider> providers) {
        this.providers = providers;
    }

    public LoginResponse login(LoginRequest request) {

        return providers.stream()

                .filter(provider -> provider.supports(request.getRole()))

                .findFirst()

                .orElseThrow(() ->
                        new RuntimeException("Invalid role"))

                .login(request);

    }

}