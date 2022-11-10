package com.software.gameHub.entity.dto;

import com.software.gameHub.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketRequest {
    private Customer customer;

}
