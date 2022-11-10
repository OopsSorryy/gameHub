package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.WalletIdDoesNotExistException;
import com.software.gameHub.entity.dto.AddBalanceRequest;
import com.software.gameHub.entity.dto.WalletDto;
import com.software.gameHub.entity.dto.converter.WalletConverter;
import com.software.gameHub.entity.Wallet;
import com.software.gameHub.repository.WalletDao;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletDao walletDao;

    private final WalletConverter walletConverter;

    public WalletService(WalletDao walletDao, WalletConverter walletConverter) {
        this.walletDao = walletDao;
        this.walletConverter = walletConverter;
    }

    protected Wallet create(){
        Wallet wallet =new Wallet();
        return walletDao.save(wallet);
    }

    public WalletDto addBalance(AddBalanceRequest request){
        Wallet wallet = findById(request.getWalletId());
        wallet.setBalance(request.getBalance());
        return walletConverter.convert(walletDao.save(wallet));
    }

    protected Wallet findById(int walletId){
        return walletDao.findById(walletId).orElseThrow
                (
                ()-> new WalletIdDoesNotExistException(Constant.WALLET_ID_DOES_NOT_EXIST)
                );
    }
}
