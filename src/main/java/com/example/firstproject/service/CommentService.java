package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository; //article 데이터도 db에서 가져올 필요가 있어서

    public List<CommentDto> comments(Long articleId) {

        /*
        조회: 댓글 목록
        List<Comment> comments = commentRepository.findByArticleId(articleId); // Comment Entity타입 묶음으로 반환
        변환: 엔티티 -> DTO
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for (int i = 0; i < comments.size(); i++) { //댓글을 변환해서 집어넣는다
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }
        반환
        return dtos;
        */

        return commentRepository.findByArticleId(articleId)
                .stream()// '데이터 처리연산을 지원하도록 소스에서 추출된 연속된 요소'
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList()); //List로 변환
    }

    @Transactional //DB를 건들이기 때문에, DB의 변경이 일어날 수 있기 때문에 해줘야한다.
    public CommentDto create(Long articleId, CommentDto dto) {
        //게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId) //게시글 조회
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다.")); //예외 발생
        //댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article); //comment로 만들어줌
        //댓글 엔티티를 DB로 저장
        Comment created = commentRepository.save(comment);
        //DTO로 변경하여 반환
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        //댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다."));

        //댓글 수정
        target.patch(dto);

        //DB로 갱신
        Comment updated = commentRepository.save(target);

        //댓글 엔티티를 DTO로 변환 및 반환
        return CommentDto.createCommentDto(updated);
    }

    @Transactional //DB를 건들임
    public CommentDto delete(Long id) {
        //댓글 조회(및 예외 발생)
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상이 없습니다."));

        //댓글 DB에서 삭제
        commentRepository.delete(target);

        //삭제 댓글을 DTO 반환
        return CommentDto.createCommentDto(target);
    }
}
