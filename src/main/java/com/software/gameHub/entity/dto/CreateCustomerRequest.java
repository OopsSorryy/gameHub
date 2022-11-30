package com.software.gameHub.entity.dto;

import com.software.gameHub.core.validator.PasswordMatches;
import com.software.gameHub.core.validator.ValidPassword;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@PasswordMatches
public class CreateCustomerRequest {

    @NotBlank
    @Email(regexp = ".+@.+\\..+")
    private String mail;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @ValidPassword
    @NotBlank
    private String password;

    @NotBlank
    private String passwordMatch;


}
