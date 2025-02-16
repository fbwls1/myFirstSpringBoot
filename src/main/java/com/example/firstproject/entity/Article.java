package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {

    //테이블 구성?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 id 자동 생성
    private Long id; //대표값(@Id)이자 랜덤값(@GeneratedValue)
    @Column
    private String title; //속성1(@Column)
    @Column
    private String content; //속성2(@Column)


    public void patch(Article article) {
        if(article.title != null) {
            this.title = article.title;
        }
        if(article.content != null) {
            this.content = article.content;
        }
    }
}
