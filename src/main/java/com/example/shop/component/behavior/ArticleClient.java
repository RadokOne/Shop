package com.example.shop.component.behavior;

import com.example.shop.component.wrapper.ArticleWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("article-service")
public interface ArticleClient {
    @PostMapping("/article/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createArticle(@RequestBody ArticleWrapper article);

    @GetMapping("/article/get")
    public List<ArticleWrapper> getAllArticles();

    @GetMapping("/article/get/{articleId}")
    public ArticleWrapper getArticle(@PathVariable int articleId);

    @DeleteMapping("/article/delete/{articleId}")
    public void deleteArticle(@PathVariable int articleId);
}
