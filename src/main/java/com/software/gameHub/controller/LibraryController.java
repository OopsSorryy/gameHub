package com.software.gameHub.controller;

import com.software.gameHub.entity.dto.LibraryDto;
import com.software.gameHub.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping("/{libraryId}")
    public ResponseEntity<LibraryDto> getAllGameById(@Valid @PathVariable("libraryId") int libraryId){
        return new ResponseEntity<>(libraryService.getAllGame(libraryId), HttpStatus.OK);
    }
}
