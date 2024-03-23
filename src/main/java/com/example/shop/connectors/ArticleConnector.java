package com.example.shop.connectors;

import com.example.shop.component.wrapper.article.ArticleWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@FeignClient("ARTICLE")
public interface ArticleConnector {

    @GetMapping("/article/{articleId}")
    public ResponseEntity<ArticleWrapper> getArticle(@PathVariable int articleId);
    @PostMapping("/article/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createArticles(@RequestBody Set<ArticleWrapper> articles);
}
