package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.LibraryDto;
import com.software.gameHub.entity.Library;
import org.springframework.stereotype.Component;

@Component
public class LibraryConverter {

    private final BuyConverter buyConverter;

    public LibraryConverter(BuyConverter buyConverter) {
        this.buyConverter = buyConverter;
    }

    public LibraryDto convert(Library from){
        return new LibraryDto(from.getLibraryId(), buyConverter.convert(from.getBuy()));
    }
}
