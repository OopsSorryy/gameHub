package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.ImageNotFoundException;
import com.software.gameHub.core.exception.MaxImageException;
import com.software.gameHub.entity.Game;
import com.software.gameHub.entity.Image;
import com.software.gameHub.entity.dto.ImageDto;
import com.software.gameHub.entity.dto.converter.ImageConverter;
import com.software.gameHub.repository.ImageDao;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageService  {

    private final ImageDao imageDao;

    private final GameService gameService;
    private final ImageConverter imageConverter;
    private final CloudStorageService cloudStorageService;

    public ImageService(ImageDao imageDao, GameService gameService, ImageConverter imageConverter, CloudStorageService cloudStorageService) {
        this.imageDao = imageDao;
        this.gameService = gameService;
        this.imageConverter = imageConverter;
        this.cloudStorageService = cloudStorageService;
    }

    protected Image getImageByImageId(int imageId){
        return imageDao.findById(imageId).orElseThrow(() -> new ImageNotFoundException(Constant.IMAGE_NOT_FOUND));
    }

    protected void maxImageControl(int gameId){
        List<Image> images =imageDao.findAll();
        List<Integer> gameIds = images.stream().map(Image::getGame).map(Game::getGameId).toList();
        int count =1;

        for (Integer id : gameIds) {
            if (id == gameId) {
                count++;
                if (count == 6) {
                    throw new MaxImageException(Constant.MAX_IMAGE_LESS_THAN_SIX);
                }
            }
        }
    }

    public ImageDto addImage(MultipartFile multipartFile, int gameId) {
        maxImageControl(gameId);
        Map<?,?> upload = cloudStorageService.upload(multipartFile);
        Game game =gameService.findById(gameId);
        Image image = new Image(upload.get("url").toString(),game);
        return imageConverter.convert(imageDao.save(image));
    }

    public void deleteImageByImageId(int imageId){
        imageDao.deleteById(getImageByImageId(imageId).getImageId());
    }

}