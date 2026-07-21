package com.backend.service.auth;

import com.backend.dto.LoginRequest;
import com.backend.dto.LoginResponse;

public interface AuthProvider {

    boolean supports(String role);

    LoginResponse login(LoginRequest request);

}