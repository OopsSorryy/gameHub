package com.software.gameHub.controller;

import com.software.gameHub.entity.dto.ImageDto;
import com.software.gameHub.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequestMapping("/image")
@RestController
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageService imageService;


    public ImageController( ImageService imageService) {
        this.imageService = imageService;

    }

    @PostMapping()
    public ResponseEntity<ImageDto> createImage(@Valid @RequestParam("file") MultipartFile multipartFile,
                                                @Valid @RequestParam("gameId") int gameId)
    {

        return  new ResponseEntity<>(imageService.addImage(multipartFile,gameId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<Void> deleteImageByImageId(@PathVariable int imageId){
        imageService.deleteImageByImageId(imageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
