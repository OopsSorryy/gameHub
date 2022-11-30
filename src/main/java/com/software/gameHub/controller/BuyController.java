package com.software.gameHub.controller;


import com.software.gameHub.entity.dto.BuyDto;
import com.software.gameHub.entity.dto.CreateBuyRequest;

import com.software.gameHub.service.BuyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/buy")
@CrossOrigin(origins = "*")
public class BuyController {

    private final BuyService buyService;

    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @PostMapping("/buy")
    public ResponseEntity<BuyDto> buy(@Valid @RequestBody CreateBuyRequest request){
        return new ResponseEntity<>(buyService.buy(request), HttpStatus.CREATED);
    }
    @PostMapping("/{customerId}")
    public ResponseEntity<Void>buyFromBasket(@Valid @PathVariable int customerId){
        buyService.buyFromBasket(customerId);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }


}
