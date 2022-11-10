package com.software.gameHub.service;

import com.software.gameHub.entity.Library;
import com.software.gameHub.entity.dto.LibraryDto;
import com.software.gameHub.entity.dto.converter.LibraryConverter;
import com.software.gameHub.repository.LibraryDao;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final LibraryDao libraryDao;

    private final LibraryConverter libraryConverter;

    public LibraryService(LibraryDao libraryDao, LibraryConverter libraryConverter) {
        this.libraryDao = libraryDao;
        this.libraryConverter = libraryConverter;
    }

    protected Library create(){
        Library library = new Library();
        return libraryDao.save(library);
    }
}
