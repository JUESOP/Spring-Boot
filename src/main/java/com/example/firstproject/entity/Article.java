package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity //JPA가 관리, 테이블과의 매핑
@AllArgsConstructor //모든 필드의 생성자를 자동 생성
@ToString
@Getter
public class Article {

    @Id //기본키 직접 할당
    @GeneratedValue //JPA가 테이블의 기본키 값을 자동으로 생성
    private Long id;

    @Column //객체 필드를 테이블의 컬럼에 매핑
    private String title;

    @Column
    private String content;

    public Article() {}

    public void patch(Article article) {
        if (article.title != null) {
            this.title = article.title;
        }
        if (article.content != null) {
            this.content = article.content;
        }
    }
}
