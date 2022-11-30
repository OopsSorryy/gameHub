package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.GameAlreadyExistInLibrary;
import com.software.gameHub.entity.GameInTheBasket;
import com.software.gameHub.entity.dto.BasketGameDto;
import com.software.gameHub.entity.dto.BuyDto;
import com.software.gameHub.entity.dto.CreateBuyRequest;
import com.software.gameHub.entity.dto.DeleteGameFromBasketRequest;
import com.software.gameHub.entity.dto.converter.BuyConverter;
import com.software.gameHub.entity.Buy;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.entity.Game;
import com.software.gameHub.repository.BuyDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyService {

    private final BuyDao buyDao;

    private final CustomerService customerService;

    private final GameService gameService;

    private final BuyConverter buyConverter;

    private final GameInTheBasketService  gameInTheBasketService;

    private final BasketService basketService;

    public BuyService(BuyDao buyDao, CustomerService customerService, GameService gameService, BuyConverter buyConverter, GameInTheBasketService gameInTheBasketService, BasketService basketService) {
        this.buyDao = buyDao;
        this.customerService = customerService;
        this.gameService = gameService;
        this.buyConverter = buyConverter;
        this.gameInTheBasketService = gameInTheBasketService;
        this.basketService = basketService;
    }

    public BuyDto buy(CreateBuyRequest request){

        Customer customer = customerService.findById(request.getCustomerId());
        Game game = gameService.findById(request.getGameId());
        gameInLibraryControl(request.getCustomerId(),request.getGameId());
        Buy buy = new Buy
                (
                        customer,
                        game,
                        customer.getLibrary()
                );
        game.setThereInLibrary(true);
        return buyConverter.convert(buyDao.save(buy));
    }

    private void gameInLibraryControl(int customerId,int gameId) {
        if(buyDao.findByCustomer_CustomerIdAndGame_GameId(customerId,gameId).isPresent()){
            throw new GameAlreadyExistInLibrary(Constant.GAME_ALREADY_EXISTS_IN_LIBRARY);
        }
    }

    public void buyFromBasket(int customerId){
        List<BasketGameDto> all
                = gameInTheBasketService.getAll(basketService.getBasketByCustomerId(customerId).getBasketId());
        Customer customer = customerService.findById(customerId);
    //TODO stream ları kaldır repo yaz
        List<Game> games  =all.stream().map(BasketGameDto::getGameId).map(gameService::findById).toList();
        List<Buy> buys = games.stream().map(game -> new Buy(customer, game, customer.getLibrary())).toList();
        buys.forEach(
                buy ->gameInLibraryControl(
                        buy.getCustomer().getCustomerId(),buy.getGame().getGameId()));
        buyDao.saveAll(buys);
        games.forEach(
                game -> gameInTheBasketService.deleteGameFromBasket(
                        new DeleteGameFromBasketRequest(customer.getCustomerId(),game.getGameId())));
        


    }


}
