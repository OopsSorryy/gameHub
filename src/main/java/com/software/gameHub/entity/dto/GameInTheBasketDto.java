package com.software.gameHub.entity.dto;

import com.software.gameHub.entity.Basket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInTheBasketDto {

    private int gameInTheBasketId;

    private BasketGameDto game;

    private BasketDto Basket;
}
