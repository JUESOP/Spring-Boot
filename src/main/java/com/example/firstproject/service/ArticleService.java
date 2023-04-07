package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //서비스 선언! (서비스 객체를 스프링부트에 생성)
public class ArticleService {
    @Autowired //DI, 스프링이 관리하는 빈을 주입 받는다, 필드 주입
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        //엔티티 생성
        Article article = dto.toEntity();
        //존재하는 아이디면,
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {

        //수정 엔티티 생성
        Article article = dto.toEntity();

        //origin 대상 엔티티 찾기
        Article target = articleRepository.findById(id).orElse(null);

        //잘못된 요청 처리 (대상이 없거나 id가 다른 경우)
        if (target == null || id != article.getId()) {
            return null;
        }

        //업데이트 및 정상 응답
        target.patch(article);
        return articleRepository.save(target);
    }

    public Article delete(Long id) {

        //대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        //잘못된 요청 처리
        if (target == null) {
            return null;
        }

        //대상 삭제
        articleRepository.delete(target);
        return target;

    }
}
