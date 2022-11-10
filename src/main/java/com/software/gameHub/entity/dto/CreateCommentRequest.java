package com.software.gameHub.entity.dto;

import lombok.Data;

@Data
public class CreateCommentRequest {

    private String comment;

    private int customerId;

    private int gameId;

}
