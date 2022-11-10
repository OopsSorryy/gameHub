package com.software.gameHub.repository;

import com.software.gameHub.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryDao extends JpaRepository<Category,Integer> {

    Optional<Category> findCategoryByName(String name);
}
