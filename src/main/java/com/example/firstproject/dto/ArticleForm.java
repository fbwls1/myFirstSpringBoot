package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String title;
    @JsonProperty
    private String content;





    public Article toEntity() {
        return new Article(id, title, content);
    }
}
