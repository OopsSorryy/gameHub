package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.LibraryDoesntExistException;
import com.software.gameHub.entity.Library;
import com.software.gameHub.entity.dto.LibraryDto;
import com.software.gameHub.entity.dto.converter.LibraryConverter;
import com.software.gameHub.repository.LibraryDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryDao libraryDao;

    private final LibraryConverter libraryConverter;

    public LibraryService(LibraryDao libraryDao, LibraryConverter libraryConverter) {
        this.libraryDao = libraryDao;
        this.libraryConverter = libraryConverter;
    }

    protected Library findById(int libraryId){
        return libraryDao.findById(libraryId).orElseThrow(
                ()-> new LibraryDoesntExistException(Constant.LIBRARY_DOESNT_EXIST));
    }

    public LibraryDto getAllGame(int libraryId){
        return libraryConverter.convert(findById(libraryId));
    }
    protected Library create(){
        Library library = new Library();
        return libraryDao.save(library);
    }
}
