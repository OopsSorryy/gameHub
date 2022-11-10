package com.software.gameHub.entity.dto;

import lombok.Data;

@Data
public class AddBalanceRequest {

    private int walletId;

    private double balance;
}
