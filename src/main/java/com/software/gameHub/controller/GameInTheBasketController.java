package com.software.gameHub.controller;

import com.software.gameHub.entity.dto.AddGameToBasketRequest;
import com.software.gameHub.entity.dto.BasketGameDto;
import com.software.gameHub.entity.dto.DeleteGameFromBasketRequest;
import com.software.gameHub.service.GameInTheBasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameInTheBasket")
public class GameInTheBasketController {

    private final GameInTheBasketService gameInTheBasketService;

    public GameInTheBasketController(GameInTheBasketService gameInTheBasketService) {
        this.gameInTheBasketService = gameInTheBasketService;
    }

    @GetMapping("/{basketId}")
    public ResponseEntity<List<BasketGameDto>> getAll(@PathVariable int basketId){
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
}
