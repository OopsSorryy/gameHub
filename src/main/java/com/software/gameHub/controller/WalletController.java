package com.software.gameHub.controller;

import com.software.gameHub.entity.dto.AddBalanceRequest;
import com.software.gameHub.entity.dto.WalletDto;

import com.software.gameHub.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/wallet")
@CrossOrigin(origins = "*")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PutMapping
    public ResponseEntity<WalletDto> addBalance(@Valid @RequestBody AddBalanceRequest request){
       return new ResponseEntity<>(walletService.addBalance(request), HttpStatus.OK);
    }
    @GetMapping("/{walletId}")
    public ResponseEntity<WalletDto> getById(@Valid @PathVariable("walletId") int walletId ){
        return new ResponseEntity<>(walletService.getById(walletId),HttpStatus.OK);
    }
}
