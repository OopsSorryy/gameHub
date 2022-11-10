package com.software.gameHub.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BasketGameDto {

    private int gameId;

    private String name;

    private double price;

    private List<CategoryDto> categories;

    private List<ImageDto> images;
}
