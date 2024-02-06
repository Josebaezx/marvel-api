package com.josebaezx.pruebassr.auth.service;

import com.josebaezx.pruebassr.auth.model.dto.AuthResponse;
import com.josebaezx.pruebassr.auth.model.dto.LoginRequest;
import com.josebaezx.pruebassr.auth.model.dto.RegisterRequest;
import com.josebaezx.pruebassr.auth.model.entity.User;
import com.josebaezx.pruebassr.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .password(request.getPassword())
                .salt(request.getSalt())
                .hash(request.getHash())
                .role(request.getRole())
                .build();
        userRepository.save(user);

        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }
}