package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.CustomerIdDoesNotExistException;
import com.software.gameHub.core.exception.CustomerNotFoundException;
import com.software.gameHub.core.exception.EmailAlreadyUsedException;
import com.software.gameHub.entity.Role;
import com.software.gameHub.entity.SecurityCustomer;
import com.software.gameHub.entity.dto.CreateCustomerRequest;
import com.software.gameHub.entity.dto.CustomerDto;
import com.software.gameHub.entity.dto.converter.CustomerConverter;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.repository.CustomerDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {

    private final CustomerDao customerDao;

    private final WalletService walletService;

    private final LibraryService libraryService;

    private final BasketService basketService;

    private final CustomerConverter customerConverter;
    private final BCryptPasswordEncoder passwordEncoder;

    public CustomerService(CustomerDao customerDao, WalletService walletService, LibraryService libraryService, BasketService basketService, CustomerConverter customerConverter, BCryptPasswordEncoder passwordEncoder) {
        this.customerDao = customerDao;
        this.walletService = walletService;
        this.libraryService = libraryService;
        this.basketService = basketService;
        this.customerConverter = customerConverter;
        this.passwordEncoder = passwordEncoder;
    }

    protected Customer findById(int customerId){
       return customerDao.findById(customerId).orElseThrow(
               ()->new CustomerIdDoesNotExistException(Constant.CUSTOMER_ID_DOES_NOT_EXIST));
    }
    public CustomerDto getById(int customerId){
        return customerConverter.convert(findById(customerId));
    }

    public CustomerDto create(CreateCustomerRequest request){

        customerControl(request.getMail());

        Customer customer = new Customer
                (
                        request.getMail(),
                        request.getName(),
                        request.getSurname(),
                        passwordEncoder.encode(request.getPassword()),
                        passwordEncoder.encode(request.getPasswordMatch()),
                        libraryService.create(),
                        walletService.create(),
                        basketService.create(),
                        Role.USER

                );
        return customerConverter.convert(customerDao.save(customer));
    }

    private void customerControl(String mail) {
        if(customerDao.findByMail(mail).isPresent()){
            throw new EmailAlreadyUsedException(Constant.EMAIL_ALREADY_USED);
        }
    }

    public void delete(int customerId){
        customerDao.deleteById(findById(customerId).getCustomerId());
    }
    public Customer findCustomerByEmail(String email){
        return customerDao.findByMail(email).orElseThrow(()->
                new CustomerNotFoundException(Constant.CUSTOMER_NOT_FOUND));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = findCustomerByEmail(username);
        return new SecurityCustomer(customer);
    }
}
