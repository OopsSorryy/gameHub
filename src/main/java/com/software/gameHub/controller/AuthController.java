package com.software.gameHub.controller;


import com.software.gameHub.entity.dto.LoginRequest;
import com.software.gameHub.entity.dto.LoginResponse;
import com.software.gameHub.service.AuthManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/login")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthManager authManager;

    public AuthController(AuthManager authManager) {
        this.authManager = authManager;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return new ResponseEntity<>(authManager.login(request), HttpStatus.OK);
    }
}
