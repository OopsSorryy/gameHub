package com.software.gameHub.service;

import com.software.gameHub.entity.Basket;
import com.software.gameHub.repository.BasketDao;
import org.springframework.stereotype.Service;


@Service
public class BasketService {

    private final BasketDao basketDao;



    public BasketService(BasketDao basketDao ) {
        this.basketDao = basketDao;
    }

    protected Basket create(){
        Basket basket = new Basket();
        return basketDao.save(basket);
    }

    protected Basket getBasketByCustomerId(int customerId){
        return basketDao.findBasketByCustomer_CustomerId(customerId);
    }
}
