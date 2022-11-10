package com.software.gameHub.service;

import com.software.gameHub.entity.Basket;
import com.software.gameHub.entity.Game;
import com.software.gameHub.entity.GameInTheBasket;
import com.software.gameHub.entity.dto.AddGameToBasketRequest;
import com.software.gameHub.entity.dto.BasketGameDto;
import com.software.gameHub.entity.dto.DeleteGameFromBasketRequest;
import com.software.gameHub.entity.dto.converter.BasketGameDtoConverter;
import com.software.gameHub.repository.GameInTheBasketDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameInTheBasketService {

    private final GameInTheBasketDao gameInTheBasketDao;
    private final BasketGameDtoConverter basketGameDtoConverter;
    private final BasketService basketService;

    private final GameService gameService;


    public GameInTheBasketService(GameInTheBasketDao gameInTheBasketDao, BasketGameDtoConverter basketGameDtoConverter, BasketService basketService, GameService gameService) {
        this.gameInTheBasketDao = gameInTheBasketDao;
        this.basketGameDtoConverter = basketGameDtoConverter;
        this.basketService = basketService;
        this.gameService = gameService;
    }

    public List<BasketGameDto> getAll(int basketId){
        List<GameInTheBasket> byBasket_basketIdIn = gameInTheBasketDao.findByBasket_BasketId(basketId);
        List<Game> games = byBasket_basketIdIn.stream().map(GameInTheBasket::getGame).toList();
        return basketGameDtoConverter.converter(games);
    }

    public void addGameToBasket(AddGameToBasketRequest addGameToBasketRequest){
        Basket basket = basketService.getBasketByCustomerId(addGameToBasketRequest.getCustomerId());
        Game game = gameService.findById(addGameToBasketRequest.getGameId());

        GameInTheBasket gameInTheBasket = new GameInTheBasket(game,basket);

        gameInTheBasketDao.save(gameInTheBasket);

    }
    //bır oyunu ıkıkez sepete ekleyemez
    //verdıgın degerlerı kontrol et
    public void deleteGameFromBasket(DeleteGameFromBasketRequest deleteGameFromBasketRequest){
        Basket basket = basketService.getBasketByCustomerId(deleteGameFromBasketRequest.getCustomerId());
        List<GameInTheBasket> byBasket_basketId =
                gameInTheBasketDao.findByBasket_BasketIdAndGame_GameId
                        (
                                basket.getBasketId(),
                                deleteGameFromBasketRequest.getGameId()
                        );
        gameInTheBasketDao.delete(byBasket_basketId.get(0));
    }
}
