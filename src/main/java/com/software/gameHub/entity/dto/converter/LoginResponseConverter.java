package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.CustomerDto;
import com.software.gameHub.entity.dto.LoginResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginResponseConverter {

    

    public LoginResponse convert(String token,CustomerDto customer){
        return new LoginResponse(token,customer);

    }
}
