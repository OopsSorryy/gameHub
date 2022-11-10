package com.software.gameHub.entity.dto;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String mail;

    private String name;

    private String surname;

    private String password;

    private String passwordMatch;


}
