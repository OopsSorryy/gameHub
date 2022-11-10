package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.BuyDto;
import com.software.gameHub.entity.Buy;
import org.springframework.stereotype.Component;

@Component
public class BuyConverter {

    private final BasketGameDtoConverter gameConverter;

    public BuyConverter(BasketGameDtoConverter gameConverter) {
        this.gameConverter = gameConverter;
    }

    public BuyDto convert(Buy from){
        if (from == null){
            return null;
        }
        return new BuyDto(from.getBuyId(), gameConverter.converter(from.getGame()));
    }
}
