package com.software.gameHub.repository;

import com.software.gameHub.entity.GameInTheBasket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameInTheBasketDao extends JpaRepository<GameInTheBasket,Integer> {
    List<GameInTheBasket> findByBasket_BasketId(int basketId);
    List<GameInTheBasket> findByBasket_BasketIdAndGame_GameId(int basketId,int gameId);
}
