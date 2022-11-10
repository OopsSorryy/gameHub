package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.CommentIdDoesNotExistException;
import com.software.gameHub.entity.dto.CommentDto;
import com.software.gameHub.entity.dto.CreateCommentRequest;
import com.software.gameHub.entity.dto.converter.CommentConverter;
import com.software.gameHub.entity.Comment;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.entity.Game;
import com.software.gameHub.repository.CommentDao;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentDao commentDao;

    private final GameService gameService;

    private final CustomerService customerService;
    private final CommentConverter commentConverter;

    public CommentService(CommentDao commentDao, GameService gameService, CustomerService customerService, CommentConverter commentConverter) {
        this.commentDao = commentDao;
        this.gameService = gameService;
        this.customerService = customerService;
        this.commentConverter = commentConverter;
    }

    public CommentDto create(CreateCommentRequest request){
        Customer customer = customerService.findById(request.getCustomerId());

        Game game = gameService.findById(request.getGameId());

        Comment comment = new Comment(request.getComment(), customer,game);

        return commentConverter.convert(commentDao.save(comment));
    }

    public void delete(int commentId){
        commentDao.deleteById(findById(commentId).getCommentId());
    }

    protected Comment findById(int commentId){
        return commentDao.findById(commentId).orElseThrow(
                ()->new CommentIdDoesNotExistException(Constant.COMMENT_ID_DOES_NOT_EXIST));
    }
}
