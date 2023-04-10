package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //jpa와 연동한 테스트! repository 테스트 하는 것
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            Long articleId = 4L;

            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            //예상하기
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Comment a = new Comment(1L, article, "Park", "굳 윌 헌팅");
            Comment b = new Comment(2L, article, "Park", "굳 윌 11헌팅");
            Comment c = new Comment(3L, article, "Park", "굳 윌22 헌팅");

            List<Comment> expected = Arrays.asList(a, b, c); //list 형태로

            //검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "Park"의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            String nickName = "Park";

            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickName);

            //예상하기
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Comment a = new Comment(1L, article,"Park", "굳 윌 헌팅");
            Comment b = new Comment(2L, article,"Park", "굳 윌 11헌팅");
            Comment c = new Comment(3L, article,"Park", "굳 윌22 헌팅");

            List<Comment> expected = Arrays.asList(a, b, c); //list 형태로
            //검증
            assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글을 출력!");
        }
    }
}