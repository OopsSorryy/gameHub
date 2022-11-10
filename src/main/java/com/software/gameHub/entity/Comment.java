package com.software.gameHub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE)
    @JoinColumn
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE)
    @JoinColumn
    private Game game;


    public Comment(String comment, Customer customer, Game game) {
        this.comment = comment;
        this.customer = customer;
        this.game = game;
    }
}
