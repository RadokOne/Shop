package com.example.shop.component.behavior;

import com.example.shop.component.wrapper.article.ArticleWrapper;
import com.example.shop.component.wrapper.customer.CartWrapper;
import com.example.shop.component.wrapper.customer.CustomerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

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