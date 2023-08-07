package com.demo.jwt.service;

import com.demo.jwt.common.dto.AuthenticateRequest;
import com.demo.jwt.common.dto.AuthenticationResponse;
import com.demo.jwt.common.dto.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticateRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
