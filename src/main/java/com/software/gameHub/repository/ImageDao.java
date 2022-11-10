package com.software.gameHub.repository;

import com.software.gameHub.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image,Integer> {
}
