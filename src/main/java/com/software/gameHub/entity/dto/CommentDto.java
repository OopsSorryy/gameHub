package com.software.gameHub.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private int commentId;

    private String comment;

    private CustomerDto customerDto;

    //private GameDto gameDto;

}
