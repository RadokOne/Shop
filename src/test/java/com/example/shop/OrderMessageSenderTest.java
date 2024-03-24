package com.example.shop;

import com.example.shop.component.behavior.CustomerService;
import com.example.shop.component.behavior.OrderMessageSender;
import com.example.shop.component.wrapper.customer.CartWrapper;
import com.example.shop.component.wrapper.customer.CustomerWrapper;
import com.example.shop.component.wrapper.order.OrderPositionWrapper;
import com.example.shop.component.wrapper.order.OrderWrapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderMessageSenderTest {


    @Autowired
    OrderMessageSender orderMessageSender;

    private static OrderPositionWrapper orderPositionWrapper;
    private static OrderWrapper orderWrapper;

        @BeforeAll
    public static void setUpBeforeClass() throws Exception{
            List<OrderPositionWrapper> orderPostions = new ArrayList<>();
            orderPostions.add(new OrderPositionWrapper("OrderPosition1", 1, 15.3F, 6));
        orderWrapper = new OrderWrapper("Order1", 1, orderPostions);

    }

    @Order(1)
    @Test
    void addOrderTest() throws Exception {
        orderMessageSender.addOrder(orderWrapper);
        Thread.sleep(3000);
    }

    @Order(2)
    @Test
    void deleteOrderTest() throws Exception{
        orderMessageSender.deleteOrder(orderWrapper);
    }

}