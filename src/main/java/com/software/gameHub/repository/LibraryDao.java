package com.software.gameHub.repository;

import com.software.gameHub.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryDao extends JpaRepository<Library,Integer> {
}
