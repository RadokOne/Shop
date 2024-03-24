package com.example.shop;

import com.example.shop.component.Shop;
import com.example.shop.component.wrapper.article.ArticleWrapper;
import com.example.shop.component.wrapper.article.BookCategoryWrapper;
import com.example.shop.component.wrapper.article.BookWrapper;
import com.example.shop.component.wrapper.customer.CartWrapper;
import com.example.shop.component.wrapper.customer.CustomerWrapper;
import com.example.shop.component.wrapper.order.OrderWrapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShopTest {

    @Autowired
    Shop shop;

    private static CustomerWrapper customer;
    private static CartWrapper cart;
    private static BookWrapper book;
    private static OrderWrapper order;

    @BeforeAll
    public static void setUp() throws Exception{
        book = new BookWrapper(99, "Herr der Ringe", "Hobbit Press", 19.9F, "J.R.R. Tolkin", BookCategoryWrapper.CRIME, "book");
        customer = new CustomerWrapper("Tim", "Am Sande 2");
        cart = new CartWrapper(customer);
        cart.addCartItem(book.getArticleId());
        customer.setCart(cart);
    }

    @Order(1)
    @Test
    void createCustomerWithCart() throws Exception {
        int customerId = shop.createCustomerWithCart("Tim", "Am Sande 2");
        customer.setCustomerId(customerId);
    }

    @Order(2)
    @Test
    void createArticle() throws Exception{
        shop.createArticle(book);
    }

    @Order(3)
    @Test
    void addArticleToCart() throws Exception{
        ArticleWrapper databaseArticle = shop.getArticle(book.getArticleId());
        shop.addArticleToCart(customer.getCustomerId(), databaseArticle.getArticleId());
        shop.addArticleToCart(customer.getCustomerId(), databaseArticle.getArticleId());
    }

    @Order(4)
    @Test
    void getArticleFromCustomer() throws Exception{
        int customerDBArticleId = shop.getCartForCustomer(customer.getCustomerId()).getCartItems().get(0).getArticleId();
        ArticleWrapper databaseBook = shop.getArticle(customerDBArticleId);
        assertThat(databaseBook.getName()).isEqualTo(book.getName());
    }

    @Order(5)
    @Test
    void decrementArticleQuantity() throws Exception{
        shop.decrementArticleQuantityInCart(customer.getCustomerId(), book.getArticleId());
        assertThat(shop.getCartForCustomer(customer.getCustomerId()).getCartItems().get(0).getQuantity()).isEqualTo(1);
    }

    @Order(6)
    @Test
    void checkOutCart() throws Exception{
        order = shop.checkOutCart(customer.getCustomerId());
        assertThat(order.getCustomerId()).isEqualTo(customer.getCustomerId());
    }

    @Order(7)
    @Test
    void removeArticleFromCart() throws Exception{
        shop.removeArticleFromCart(customer.getCustomerId(), book.getArticleId());
        assertThat(shop.getCartForCustomer(customer.getCustomerId()).getCartItems()).isEqualTo(new ArrayList<>());
    }

    @Order(8)
    @Test
    void deleteArticleOrderCustomer() throws Exception{
        shop.deleteCustomer(customer.getCustomerId());
        shop.deleteArticle(book.getArticleId());
        shop.deleteOrder(order);
    }
}
