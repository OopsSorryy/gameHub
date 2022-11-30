package com.software.gameHub.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {

    private int gameId;

    private String name;

    private double price;

    private String description;

    private boolean isThereInLibrary;

    private boolean isThereInBasket;

    private List<CategoryDto> categories;

    private List<ImageDto> images;

    private List<CommentDto> comments;



}
