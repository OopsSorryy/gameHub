package com.software.gameHub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Game game;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Library library;

    public Buy(Customer customer, Game game, Library library) {
        this.customer = customer;
        this.game = game;
        this.library = library;
    }
}