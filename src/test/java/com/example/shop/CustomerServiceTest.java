package com.example.shop;

import com.example.shop.component.behavior.CustomerService;
import com.example.shop.component.wrapper.customer.CartItemWrapper;
import com.example.shop.component.wrapper.customer.CartWrapper;
import com.example.shop.component.wrapper.customer.CustomerWrapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    private static CustomerWrapper customer;
    private static CartWrapper cart;
    private static int articleId = 1;
    private static int customerId;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception{
        customer = new CustomerWrapper("Susanne", "Sandweg 3");
        cart = new CartWrapper(customer);
        cart.addCartItem(articleId);
        customer.setCart(cart);
    }

    @Order(1)
    @Test
    void createCustomerWithCard() throws Exception{
        CustomerWrapper databaseCustomer = customerService.createCustomerWithCard(customer);
        customer.setCustomerId(databaseCustomer.getCustomerId());
    }

    @Order(2)
    @Test
    void getCustomerWithId() throws Exception{
        CustomerWrapper databaseCustomer = customerService.getCustomer(customer.getCustomerId());
        assertThat(databaseCustomer.getCustomerId()).isEqualTo(customer.getCustomerId());
    }

    @Order(3)
    @Test
    void getCart() throws Exception{
        CartWrapper cartWrapper = customerService.getCart(customer.getCustomerId());
        assertThat(cartWrapper.getCartId()).isEqualTo(customer.getCart().getCartId());
    }

    @Order(4)
    @Test
    void addArticleToCart() throws Exception{
        customerService.addArticleToCart(customer.getCustomerId(), "55");
        CartWrapper cartWrapper = customerService.getCart(customer.getCustomerId());
        assertThat(cartWrapper.getCartItems().stream().anyMatch(item -> Integer.valueOf("55").equals(item.getArticleId()))).isTrue();
    }

    @Order(5)
    @Test
    void removeArticleFromCart() throws Exception{
        customerService.removeArticleFromCart(customer.getCustomerId(), articleId);
    }

    @Order(6)
    @Test
    void deleteCustomer() throws Exception{
        customerService.deleteCustomer(customer.getCustomerId());
    }

}
