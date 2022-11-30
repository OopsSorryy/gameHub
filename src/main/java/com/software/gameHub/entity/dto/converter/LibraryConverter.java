package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.LibraryDto;
import com.software.gameHub.entity.Library;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryConverter {

    private final BuyConverter buyConverter;

    public LibraryConverter(BuyConverter buyConverter) {
        this.buyConverter = buyConverter;
    }

    public LibraryDto convert(Library from){
        return new LibraryDto(from.getLibraryId(), buyConverter.convert(from.getBuy()));
    }

    public List<LibraryDto> convert(List<Library> fromList){
        return fromList.stream().map(library -> new LibraryDto
                (
                        library.getLibraryId(),
                        buyConverter.convert(library.getBuy())
                )).collect(Collectors.toList());
    }
}
