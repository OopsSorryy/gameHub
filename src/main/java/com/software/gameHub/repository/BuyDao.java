package com.software.gameHub.repository;

import com.software.gameHub.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuyDao extends JpaRepository<Buy,Integer> {
    Optional<Buy> findByCustomer_CustomerIdAndGame_GameId(int customerId, int gameId);
}
