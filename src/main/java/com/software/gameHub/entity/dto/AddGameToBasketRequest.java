package com.software.gameHub.entity.dto;

import lombok.Data;


import javax.validation.constraints.NotNull;

@Data
public class AddGameToBasketRequest {

    @NotNull
    private int customerId;

    @NotNull
    private int gameId;
}
