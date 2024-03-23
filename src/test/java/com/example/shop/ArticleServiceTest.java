package com.example.shop;

import com.example.shop.component.behavior.ArticleService;
import com.example.shop.component.wrapper.article.ArticleWrapper;
import com.example.shop.component.wrapper.article.BookCategoryWrapper;
import com.example.shop.component.wrapper.article.BookWrapper;
import com.example.shop.component.wrapper.article.CDWrapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    BookWrapper book = new BookWrapper(1,"Servlets", "Leuphana",22.0f, "Slotos", BookCategoryWrapper.POPULAR_SCIENCE, "book");
    CDWrapper cd = new CDWrapper(2, "Cesha Album", "Sony", 30.5f, "Cesha");


    @Order(1)
    @Test
    void createBookTest() throws Exception {
        articleService.createArticle(book);
    }

    @Order(2)
    @Test
    void createCDTest() throws Exception{
        articleService.createArticle(cd);
    }

    @Order(3)
    @Test
    void getAllArticlesTest() throws Exception{
        List<ArticleWrapper> articles = articleService.getAllArticles();
        assertThat(articles.contains(book));
    }

    @Order(4)
    @Test
    void getBookById() throws Exception{
        assertThat(articleService.getArticle(book.getArticleId()).getArticleId()).isEqualTo(book.getArticleId());
    }

    @Order(5)
    @Test
    void getCDById() throws Exception{
        assertThat(articleService.getArticle(cd.getArticleId()).getArticleId()).isEqualTo(cd.getArticleId());
    }

    @Order(6)
    @Test
    void deleteCDAndBook() throws Exception{
        articleService.deleteArticle(book.getArticleId());
        articleService.deleteArticle(cd.getArticleId());
    }
}
