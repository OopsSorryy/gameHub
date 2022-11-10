package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.GameIdDoesNotExistException;
import com.software.gameHub.entity.dto.CreateGameRequest;
import com.software.gameHub.entity.dto.GameDto;
import com.software.gameHub.entity.dto.converter.GameConverter;
import com.software.gameHub.entity.Category;
import com.software.gameHub.entity.Game;
import com.software.gameHub.repository.GameDao;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class GameService {

    private final GameDao gameDao;

    private final CategoryService categoryService;

    private final GameConverter gameConverter;


    public GameService(GameDao gameDao, CategoryService categoryService, GameConverter gameConverter) {
        this.gameDao = gameDao;
        this.categoryService = categoryService;
        this.gameConverter = gameConverter;
    }

    public GameDto createGame(CreateGameRequest request){

        List<Category> categories = request.getCategoryIds().stream().map(categoryService::findById).toList();
        Game game = new Game
                (
                        request.getName(),
                        request.getPrice(),
                        categories
                );

        return gameConverter.convert(gameDao.save(game));
    }

    public void delete(int gameId){
        gameDao.deleteById(findById(gameId).getGameId());
    }

    protected Game findById(int gameId){
        return gameDao.findById(gameId).orElseThrow(()-> new GameIdDoesNotExistException(Constant.GAME_ID_DOES_NOT_EXIST));
    }

    public GameDto getById(int gameId){
        return gameConverter.convert(findById(gameId));
    }

    public List<GameDto> getAll(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return gameConverter.convert(gameDao.findAll(pageable).getContent());
    }

    public List<GameDto> findGameByCategories_CategoryIdIn(List<Integer> categories){
        return gameConverter.convert(gameDao.findGameByCategories_CategoryIdIn(categories));
    }

    public List<GameDto> findByNameStartingWith(String name){
        return gameConverter.convert(gameDao.findByNameIgnoreCaseStartingWith(name));
    }
    public List<GameDto> findByNameContaining(String name){
        return gameConverter.convert(gameDao.findByNameIgnoreCaseContaining(name));
    }

    public List<GameDto> findByOrderByName(){
        return gameConverter.convert(gameDao.findByOrderByName());
    }

    public List<GameDto> findByOrderByNameDesc(){
        return gameConverter.convert(gameDao.findByOrderByNameDesc());
    }

    public List<GameDto> findByOrderByPrice(){
        return gameConverter.convert(gameDao.findByOrderByPrice());
    }

    public List<GameDto> findByOrderByPriceDesc(){
        return gameConverter.convert(gameDao.findByOrderByPriceDesc());
    }


}

