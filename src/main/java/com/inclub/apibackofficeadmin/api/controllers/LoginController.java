package com.inclub.apibackofficeadmin.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inclub.apibackofficeadmin.aplication.services.Interface.UserService;
import com.inclub.apibackofficeadmin.domain.models.User;
import com.inclub.apibackofficeadmin.security.JWTUtil;
import com.inclub.apibackofficeadmin.security.PBKDF2Encoder;

import reactor.core.publisher.Mono;

public class LoginController {

    private JWTUtil jwtUtil;
    private PBKDF2Encoder passwordEncoder;
    private UserService userService;

    @PostMapping("/login")

    public Mono<ResponseEntity<?>> login(@RequestBody User user) {
        return userService.findByUsername(user.getUserName())
                .map((userDetails) -> {
                    if (passwordEncoder.encode(user.getPassword()).equals(userDetails.getPassword())) {
                        return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
                    } else {
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                    }
                }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
        
}
