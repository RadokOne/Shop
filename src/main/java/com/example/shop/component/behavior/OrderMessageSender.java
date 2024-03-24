package com.example.shop.component.behavior;

import com.example.shop.component.wrapper.order.OrderWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void addOrder(OrderWrapper order) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String orderJson = objectMapper.writeValueAsString(order);
        jmsTemplate.convertAndSend("addOrder", orderJson);
    }

    public void deleteOrder(OrderWrapper order) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String orderJson = objectMapper.writeValueAsString(order);
        jmsTemplate.convertAndSend("deleteOrder", orderJson);
    }
}


