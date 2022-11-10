package com.software.gameHub.controller;

import com.software.gameHub.entity.dto.CreateCustomerRequest;
import com.software.gameHub.entity.dto.CustomerDto;
import com.software.gameHub.entity.dto.GameDto;
import com.software.gameHub.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> findById(@PathVariable int customerId){
        return new ResponseEntity<>(customerService.getById(customerId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CustomerDto> create(@Valid @RequestBody CreateCustomerRequest request){
       return new ResponseEntity<>(customerService.create(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/customerId")
    public ResponseEntity<Void> delete(@RequestParam int customerId){
        customerService.delete(customerId);

        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
