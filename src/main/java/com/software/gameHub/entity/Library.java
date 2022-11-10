package com.software.gameHub.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libraryId;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "library")
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "library")
    private Buy buy;

}
