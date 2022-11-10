package com.software.gameHub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    private String name;

    private double price;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinTable(
            joinColumns = @JoinColumn,
            inverseJoinColumns = @JoinColumn)
    private List<Category> categories;

    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE,mappedBy = "game")
    private List<Comment> comments;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "game")
    private Buy buy;

    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE,mappedBy = "game")
    private List<Image> images ;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "game")
    private List<GameInTheBasket> gameInTheBaskets;

    public Game(String name, double price, List<Category> categories) {
        this.name = name;
        this.price = price;
        this.categories = categories;
    }
}
