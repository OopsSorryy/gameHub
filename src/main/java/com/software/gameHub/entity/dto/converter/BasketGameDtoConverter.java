package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.Game;
import com.software.gameHub.entity.dto.BasketGameDto;
import com.software.gameHub.entity.dto.GameDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BasketGameDtoConverter {

    private final CategoryConverter categoryConverter;
    private final ImageConverter imageConverter;

    public BasketGameDtoConverter(CategoryConverter categoryConverter, ImageConverter imageConverter) {
        this.categoryConverter = categoryConverter;
        this.imageConverter = imageConverter;
    }

    public List<BasketGameDto> converter(List<Game> fromList){
        if (fromList == null){
            return null;
        }
        return fromList.stream().map(from-> new BasketGameDto(
                from.getGameId(),
                from.getName(),
                from.getPrice(),
                categoryConverter.convert(from.getCategories()),
                imageConverter.convert(from.getImages()))).collect(Collectors.toList());

    }
    public BasketGameDto converter(Game from){
        return new BasketGameDto
                (
                        from.getGameId(),
                        from.getName(),
                        from.getPrice(),
                        categoryConverter.convert(from.getCategories()),
                        imageConverter.convert(from.getImages())

                );

    }
}
