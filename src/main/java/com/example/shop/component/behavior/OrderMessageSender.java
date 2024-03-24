package com.example.shop.component.behavior;

import com.example.shop.component.wrapper.order.OrderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendOrderMessage(String order) {
        jmsTemplate.convertAndSend("order.queue", order);

    }


}


