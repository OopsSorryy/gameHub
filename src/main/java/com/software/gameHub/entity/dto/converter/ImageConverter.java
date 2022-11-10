package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.ImageDto;
import com.software.gameHub.entity.Image;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageConverter {

    public ImageDto convert(Image from){
        return new ImageDto(from.getImageId(), from.getUrl());
    }

    public List<ImageDto> convert(List<Image> fromList){
        if (fromList == null){
            return null;
        }
        return fromList.stream().map(from->new ImageDto(from.getImageId(), from.getUrl()))
                .collect(Collectors.toList());
    }
}
