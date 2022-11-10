package com.software.gameHub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "basket")
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "basket")
    private List<GameInTheBasket> gameInTheBaskets;
}
