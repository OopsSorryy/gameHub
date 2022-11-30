package com.software.gameHub.repository;

import com.software.gameHub.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByMail(String email);
}
