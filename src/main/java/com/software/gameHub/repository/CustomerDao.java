package com.software.gameHub.repository;

import com.software.gameHub.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
}
