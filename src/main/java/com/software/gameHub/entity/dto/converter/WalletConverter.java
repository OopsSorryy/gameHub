package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.WalletDto;
import com.software.gameHub.entity.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletConverter {

    public WalletDto convert(Wallet from){
        return new WalletDto(from.getWalletId(),
                from.getBalance());
    }
}
