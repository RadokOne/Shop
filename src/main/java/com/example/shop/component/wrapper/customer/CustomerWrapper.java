package com.example.shop.component.wrapper.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class CustomerWrapper {

    private int customerId;
    private String name;
    private String address;
    @JsonManagedReference
    private CartWrapper cart;

    public CustomerWrapper(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setCart(CartWrapper cart) {
        this.cart = cart;
        cart.setCustomer(this);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CartWrapper getCart() {
        return cart;
    }


}
