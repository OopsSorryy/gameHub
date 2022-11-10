package com.software.gameHub.repository;

import com.software.gameHub.entity.Basket;
import com.software.gameHub.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketDao extends JpaRepository<Basket,Integer> {

    Basket findBasketByCustomer_CustomerId(Integer customerId);

}
