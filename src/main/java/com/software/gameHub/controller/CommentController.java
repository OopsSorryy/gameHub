package com.software.gameHub.controller;


import com.software.gameHub.entity.dto.CommentDto;
import com.software.gameHub.entity.dto.CreateCommentRequest;
import com.software.gameHub.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> create(@Valid @RequestBody CreateCommentRequest request){
        return new ResponseEntity<>(commentService.create(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/commentId")
    public ResponseEntity<Void> delete(@RequestParam int commentId){
       commentService.delete(commentId);
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
