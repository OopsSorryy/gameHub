package com.software.gameHub.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGameRequest {

    private String name;

    private double price;

    private List<Integer> categoryIds;
}
