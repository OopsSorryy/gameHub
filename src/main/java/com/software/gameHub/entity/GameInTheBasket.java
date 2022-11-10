package com.software.gameHub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class GameInTheBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameInTheBasketId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Basket basket;

    public GameInTheBasket(Game game, Basket basket) {
        this.game = game;
        this.basket = basket;
    }
}
