package com.software.gameHub.repository;

import com.software.gameHub.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletDao extends JpaRepository<Wallet,Integer> {
}
