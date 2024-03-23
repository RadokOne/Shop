package com.example.shop.component.wrapper.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class CartItemWrapper {
    private Long id;
    private int articleId;
    private int quantity;

    @JsonBackReference
    private CartWrapper cart;

    public CartItemWrapper(CartWrapper cart, int articleId) {
        this.cart = cart;
        this.articleId = articleId;
        //this.price = price;
        quantity = 1;
    }

    public CartItemWrapper() {}

    public void incrementQuantity() {
        quantity++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartWrapper getCart() {
        return cart;
    }

    public void setCart(CartWrapper cart) {
        this.cart = cart;
    }
}
