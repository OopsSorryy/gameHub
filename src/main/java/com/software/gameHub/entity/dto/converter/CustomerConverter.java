package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.CustomerDto;
import com.software.gameHub.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    private final WalletConverter walletConverter;
    private final BasketConverter basketConverter;


    private final LibraryConverter libraryConverter;


    public CustomerConverter(WalletConverter walletConverter, BasketConverter basketConverter,
                             LibraryConverter libraryConverter) {
        this.walletConverter = walletConverter;
        this.basketConverter = basketConverter;
        this.libraryConverter = libraryConverter;
    }

    public CustomerDto convert(Customer from){
        return new CustomerDto
                (
                        from.getCustomerId(),
                        from.getMail(),
                        from.getName(),
                        libraryConverter.convert(from.getLibrary()),
                        walletConverter.convert(from.getWallet()),
                        basketConverter.convert(from.getBasket())
                );



    }
}
