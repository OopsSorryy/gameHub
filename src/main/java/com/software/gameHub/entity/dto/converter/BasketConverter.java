package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.Basket;
import com.software.gameHub.entity.dto.BasketDto;
import org.springframework.stereotype.Component;

@Component
public class BasketConverter {

    public BasketDto convert(Basket from){
        return new BasketDto(from.getBasketId());

    }
}
