package com.example.firstproject.dto;

import com.example.firstproject.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
    private Long id;
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment c) {
        return new CommentDto(
                comment.getId
        );
    }
}
