package com.software.gameHub.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDto {

    private int libraryId;

    private BuyDto buy;
}
