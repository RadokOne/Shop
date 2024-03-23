package com.example.shop.component.behavior;

import com.example.shop.component.wrapper.ArticleWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {


    @Autowired
    private ArticleClient articleClient;

    public void createArticle(ArticleWrapper article) {
        articleClient.createArticle(article);
    }

    public List<ArticleWrapper> getAllArticles() {
        return articleClient.getAllArticles();
    }

    public ArticleWrapper getArticle(int articleId){
        return articleClient.getArticle(articleId);
    }

    public void deleteArticle(int articleId){
        articleClient.deleteArticle(articleId);
    }

}
