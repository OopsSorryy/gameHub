package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.CommentDto;
import com.software.gameHub.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CommentConverter {



    private final CustomerConverter customerConverter;

    public CommentConverter( CustomerConverter customerConverter) {
        this.customerConverter = customerConverter;
    }

    public CommentDto convert (Comment from){

        if(from == null){
            return null;
        }
        return new CommentDto
                (
                        from.getCommentId(),
                        from.getComment(),
                        customerConverter.convert(from.getCustomer()
                        )
                );
    }
    public List<CommentDto> convert(List<Comment> fromList){
        if(fromList == null){
            return null;
        }
        return fromList.
                stream().
                map(from -> new CommentDto
                        (
                                from.getCommentId(),
                                from.getComment(),
                                customerConverter.convert(from.getCustomer())
                        )).collect(Collectors.toList());
    }
}
