package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.GameAlreadyExistsInBasketException;
import com.software.gameHub.core.exception.GameIdDoesNotExistException;
import com.software.gameHub.entity.Basket;
import com.software.gameHub.entity.dto.AddGameToBasketRequest;
import com.software.gameHub.entity.dto.BasketGameDto;
import com.software.gameHub.entity.dto.DeleteGameFromBasketRequest;
import com.software.gameHub.entity.Buy;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.entity.Game;
import com.software.gameHub.entity.dto.converter.BasketGameDtoConverter;
import com.software.gameHub.repository.BasketDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final BasketDao basketDao;



    public BasketService(BasketDao basketDao ) {
        this.basketDao = basketDao;
    }

    protected Basket create(){
        Basket basket = new Basket();
        return basketDao.save(basket);
    }

    protected Basket getBasketByCustomerId(int customerId){
        return basketDao.findBasketByCustomer_CustomerId(customerId);
    }
//    public void deleteGameFromBasket(DeleteGameFromBasketRequest request ){
//        Game game = gameService.findById(request.getGameId());
//        Basket basket = getBasketByCustomerId(request.getCustomerId());
//        List<Game> collect = basket.getGames().stream()
//                .filter(game1 -> game1.equals(game)).toList();
//
//        if(collect.get(0) == null){
//            throw new GameIdDoesNotExistException(Constant.GAME_ID_DOES_NOT_EXIST);
//        }
//        else{
//             basket.getGames().remove(game);
//
//        }
//
//
//    }

//    public List<BasketGameDto> addGameToBasket(AddGameToBasketRequest request){
//
//        Basket basket = getBasketByCustomerId(request.getCustomerId());
//        Game game = gameService.findById(request.getGameId());
//        List<Game> collect = basket.getGames().stream()
//                .filter(game1 -> game1.equals(game)).toList();
//
//        if(collect.get(0) != null){
//            throw new GameAlreadyExistsInBasketException(Constant.GAME_ALREADY_EXISTS_IN_BASKET);
//        }
//        basket.getGames().add(game);
//        return basketGameDtoConverter.converter(basket.getGames());
//    }
//
//    public List<Buy> buyGameFromBasket(int customerId){
//        Customer customer = getBasketByCustomerId(customerId).getCustomer();
//
//        List<Game> games = customer.getBasket().getGames();
//
//        return  games.stream().map(game -> new Buy(customer, game, customer.getLibrary())).collect(Collectors.toList());
//
//    }
}
