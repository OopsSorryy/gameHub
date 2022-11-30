package com.software.gameHub.entity;

import lombok.Data;

import java.util.List;

import javax.persistence.*;



@Data
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libraryId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "library")
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "library")
    private List<Buy> buy;

}
