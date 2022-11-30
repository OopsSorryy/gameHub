package com.software.gameHub.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateCommentRequest {

    @NotBlank
    private String comment;
    @NotNull
    private int customerId;
    @NotNull
    private int gameId;

}
