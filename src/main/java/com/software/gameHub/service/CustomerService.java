package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.CustomerIdDoesNotExistException;
import com.software.gameHub.entity.dto.CreateCustomerRequest;
import com.software.gameHub.entity.dto.CustomerDto;
import com.software.gameHub.entity.dto.GameDto;
import com.software.gameHub.entity.dto.converter.CustomerConverter;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.repository.CustomerDao;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    private final WalletService walletService;

    private final LibraryService libraryService;

    private final BasketService basketService;

    private final CustomerConverter customerConverter;

    public CustomerService(CustomerDao customerDao, WalletService walletService, LibraryService libraryService, BasketService basketService, CustomerConverter customerConverter) {
        this.customerDao = customerDao;
        this.walletService = walletService;
        this.libraryService = libraryService;
        this.basketService = basketService;
        this.customerConverter = customerConverter;
    }

    protected Customer findById(int customerId){
       return customerDao.findById(customerId).orElseThrow(
               ()->new CustomerIdDoesNotExistException(Constant.CUSTOMER_ID_DOES_NOT_EXIST));
    }
    public CustomerDto getById(int customerId){
        return customerConverter.convert(findById(customerId));
    }

    public CustomerDto create(CreateCustomerRequest request){


        Customer customer = new Customer
                (
                        request.getMail(),
                        request.getName(),
                        request.getSurname(),
                        request.getPassword(),
                        request.getPasswordMatch(),
                        libraryService.create(),
                        walletService.create(),
                        basketService.create()

                );
        return customerConverter.convert(customerDao.save(customer));
    }

    public void delete(int customerId){
        customerDao.deleteById(findById(customerId).getCustomerId());
    }
}
