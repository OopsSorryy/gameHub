package com.software.gameHub.entity.dto;

import lombok.Data;

@Data
public class CreateBuyRequest {

    private int customerId;

    private int gameId;
}
