package com.software.gameHub.repository;

import com.software.gameHub.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Integer> {
}
