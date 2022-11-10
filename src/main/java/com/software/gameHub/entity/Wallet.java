package com.software.gameHub.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int walletId;

    private double balance;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "wallet")
    private Customer customer;

}
