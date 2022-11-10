package com.software.gameHub.entity.dto.converter;


import com.software.gameHub.entity.dto.CategoryDto;
import com.software.gameHub.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter {

    public CategoryDto convert(Category from){
        return new CategoryDto(from.getCategoryId(), from.getName());
    }


    public List<CategoryDto> convert(List<Category> fromList){
        return fromList.stream().map(from -> new CategoryDto(from.getCategoryId(), from.getName()))
                        .collect(Collectors.toList());
    }
}
