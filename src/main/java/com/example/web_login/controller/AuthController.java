package com.example.web_login.controller;

import com.example.web_login.dto.request.ApiResponse;
import com.example.web_login.dto.request.AuthRequest;
import com.example.web_login.dto.response.AuthResponse;
import com.example.web_login.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    AuthService authService;
    @PostMapping("/login")
    ApiResponse<AuthResponse> authenticate(@RequestBody AuthRequest authRequest){
        var results = authService.authenticate(authRequest);
        return ApiResponse.<AuthResponse>builder()
                .result(results)
                .build();


    }
}
