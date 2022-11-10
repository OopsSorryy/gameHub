package com.software.gameHub.service;

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


        Buy buy = new Buy
                (
                        customer,
                        game,
                        customer.getLibrary()
                );

        return buyConverter.convert(buyDao.save(buy));
    }

    public void buyFromBasket(int customerId){
        List<BasketGameDto> all
                = gameInTheBasketService.getAll(basketService.getBasketByCustomerId(customerId).getBasketId());
        Customer customer = customerService.findById(customerId);

        List<Game> games  =all.stream().map(BasketGameDto::getGameId).map(gameService::findById).toList();
        List<Buy> buys = games.stream().map(game -> new Buy(customer, game, customer.getLibrary())).toList();
        List<Buy> buys1 = buys.stream().map(buyDao::save).toList();
        games.forEach(
                game -> gameInTheBasketService.deleteGameFromBasket(
                        new DeleteGameFromBasketRequest(customer.getCustomerId(),game.getGameId())));


    }
}
