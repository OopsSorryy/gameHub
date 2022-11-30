package com.software.gameHub.service;

import com.software.gameHub.core.security.JwtUtil;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.entity.dto.LoginRequest;
import com.software.gameHub.entity.dto.LoginResponse;
import com.software.gameHub.entity.dto.converter.CustomerConverter;
import com.software.gameHub.entity.dto.converter.LoginResponseConverter;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthManager {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomerConverter customerConverter;
    private final CustomerService customerService;

    private final LoginResponseConverter converter;


    public LoginResponse login(LoginRequest request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                (request.getEmail(),
                        request.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        Customer findCustomerByEmail = customerService.findCustomerByEmail(request.getEmail());
        return converter.convert(jwtUtil.generateToken(authenticate),customerConverter.convert(findCustomerByEmail));
    }
}
