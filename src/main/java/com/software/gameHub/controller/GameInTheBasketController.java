package com.software.gameHub.controller;

import com.software.gameHub.entity.GameInTheBasket;
import com.software.gameHub.entity.dto.AddGameToBasketRequest;
import com.software.gameHub.entity.dto.GameDtoInBasket;
import com.software.gameHub.entity.dto.DeleteGameFromBasketRequest;
import com.software.gameHub.repository.GameInTheBasketDao;
import com.software.gameHub.service.GameInTheBasketService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/gameInTheBasket")
@CrossOrigin(origins = "*")
public class GameInTheBasketController {

    private final GameInTheBasketService gameInTheBasketService;
    private final GameInTheBasketDao gameInTheBasketDao;

   
    @GetMapping("/{basketId}")
    public ResponseEntity<List<GameDtoInBasket>> getAll(@PathVariable int basketId){
        return new ResponseEntity<>(gameInTheBasketService.getAll(basketId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addGameToBasket(@RequestBody AddGameToBasketRequest addGameToBasketRequest){
        gameInTheBasketService.addGameToBasket(addGameToBasketRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteGameFromBasket(@RequestBody DeleteGameFromBasketRequest deleteGameFromBasketRequest){
        gameInTheBasketService.deleteGameFromBasket(deleteGameFromBasketRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{basketId}/{gameId}")
    public ResponseEntity<List<GameInTheBasket>> getAll(@PathVariable int basketId,@PathVariable int gameId){
        return new ResponseEntity<>(gameInTheBasketDao.findByBasket_BasketIdAndGame_GameId(basketId, gameId), HttpStatus.OK);
    }

}
