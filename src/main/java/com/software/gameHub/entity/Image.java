package com.software.gameHub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Game game;

    public Image(String url, Game game) {
        this.url = url;
        this.game = game;
    }
}
