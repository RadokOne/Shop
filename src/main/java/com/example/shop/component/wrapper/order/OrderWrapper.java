package com.example.shop.component.wrapper.order;

import java.io.Serializable;
import java.util.List;

public class OrderWrapper implements Serializable {
    private String orderId;
    private Integer customerId;
    private List<OrderPositionWrapper> orderPositions;

    public OrderWrapper(String orderId, Integer customerId, List<OrderPositionWrapper> orderPositions) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderPositions = orderPositions;
    }

    public OrderWrapper() {}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<OrderPositionWrapper> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPositionWrapper> orderPositions) {
        this.orderPositions = orderPositions;
    }
}
