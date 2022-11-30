package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.GameDto;
import com.software.gameHub.entity.Game;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameConverter {

    private final CommentConverter commentConverter;
    private final CategoryConverter categoryConverter;
    private final ImageConverter imageConverter;

    public GameConverter(CommentConverter commentConverter, CategoryConverter categoryConverter, ImageConverter imageConverter) {
        this.commentConverter = commentConverter;
        this.categoryConverter = categoryConverter;
        this.imageConverter = imageConverter;
    }

    public GameDto convert(Game from){
        return new GameDto
                (
                        from.getGameId(),
                        from.getName(),
                        from.getPrice(),
                        from.getDescription(),
                        from.isThereInLibrary(),
                        from.isThereInBasket(),
                        categoryConverter.convert(from.getCategories()),
                        imageConverter.convert(from.getImages()),
                        commentConverter.convert(from.getComments())

                );
    }
    public List<GameDto> convert(List<Game> fromList){
        return fromList.stream().map(from-> new GameDto( from.getGameId(),
                from.getName(),
                from.getPrice(),
                from.getDescription(),
                from.isThereInLibrary(),
                from.isThereInBasket(),
                categoryConverter.convert(from.getCategories()),
                imageConverter.convert(from.getImages()),
                commentConverter.convert(from.getComments()))).collect(Collectors.toList());
    }
}
