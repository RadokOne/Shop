package com.example.shop;

import com.example.shop.component.behavior.ShopService;
import com.example.shop.component.wrapper.ArticleWrapper;
import com.example.shop.component.wrapper.BookCategoryWrapper;
import com.example.shop.component.wrapper.BookWrapper;
import com.example.shop.component.wrapper.CDWrapper;
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
public class ShopTest {

    @Autowired
    private ShopService shopService;

    BookWrapper book = new BookWrapper(1,"Servlets", "Leuphana",22.0f, "Slotos", BookCategoryWrapper.POPULAR_SCIENCE, "book");
    CDWrapper cd = new CDWrapper(2, "Cesha Album", "Sony", 30.5f, "Cesha");

    @Order(1)
    @Test
    void createBookTest() throws Exception {
        shopService.createArticle(book);
    }

    @Order(2)
    @Test
    void createCDTest() throws Exception{
        shopService.createArticle(cd);
    }

    @Order(3)
    @Test
    void getAllArticlesTest() throws Exception{
        List<ArticleWrapper> articles = shopService.getAllArticles();
        assertThat(articles.contains(book));
    }

    @Order(4)
    @Test
    void getBookById() throws Exception{
        assertThat(shopService.getArticle(book.getArticleId()).getArticleId()).isEqualTo(book.getArticleId());
    }

    @Order(5)
    @Test
    void getCDById() throws Exception{
        assertThat(shopService.getArticle(cd.getArticleId()).getArticleId()).isEqualTo(cd.getArticleId());
    }

    @Order(6)
    @Test
    void deleteCDAndBook() throws Exception{
        shopService.deleteArticle(book.getArticleId());
        shopService.deleteArticle(cd.getArticleId());
    }
}
