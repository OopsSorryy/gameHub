package com.software.gameHub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String mail;
//username olsun
    private String name;

    private String surname;

    private String password;

    private String passwordMatch;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Library library;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn()
    private Wallet wallet;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Basket basket;

    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.MERGE,mappedBy = "customer")
    private List<Comment> comments;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    private Buy buy;

    public Customer
            (
                    String mail,
                    String name,
                    String surname,
                    String password,
                    String passwordMatch,
                    Library library,
                    Wallet wallet,
                    Basket basket
            ) {
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.passwordMatch = passwordMatch;
        this.library = library;
        this.wallet = wallet;
        this.basket = basket;
    }
}
