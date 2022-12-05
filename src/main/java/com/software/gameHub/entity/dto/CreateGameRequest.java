package com.software.gameHub.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGameRequest {

    @NotBlank
    private String name;

    @NotBlank
    private double price;

    @NotBlank
    private String description;

    @NotBlank
    private String url;

    @NotBlank
    private List<Integer> categoryIds;
}
