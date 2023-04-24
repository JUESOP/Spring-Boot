package com.example.firstproject.api;

import com.example.firstproject.annotation.RunningTime;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    //댓글 목록 조회
    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
        //서비스에게 위임
        List<CommentDto> dtos = commentService.comments(articleId);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,
                                             @RequestBody CommentDto dto) {
        //서비스에게 위임
        CommentDto createdDto = commentService.create(articleId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id,
                                             @RequestBody CommentDto dto) {
        //서비스에게 위임
        CommentDto updatedDto = commentService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @RunningTime
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        //서비스에게 위임
        CommentDto deleted = commentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}
