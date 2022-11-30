package com.software.gameHub.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteGameFromBasketRequest {

    @NotNull
    private int customerId;
    @NotNull
    private int gameId;
}
