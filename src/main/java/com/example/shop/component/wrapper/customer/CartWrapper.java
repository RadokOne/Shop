package com.example.shop.component.wrapper.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

public class CartWrapper {
    private int cartId;


    @JsonBackReference
    private CustomerWrapper customer;
    @JsonManagedReference
    private List<CartItemWrapper> cartItems;
    private int numberOfArticles;

    public CartWrapper(CustomerWrapper customer) {
        this.customer = customer;
        cartItems = new ArrayList<>();
        customer.setCart(this);
    }

    public CartWrapper(){}

    public boolean addCartItem(int articleId) {
        for (CartItemWrapper item : cartItems) {
            if (item.getArticleId() == articleId) {
                item.incrementQuantity();
                numberOfArticles++;
                return true;
            }
        }
        CartItemWrapper newCartItem = new CartItemWrapper(this, articleId);
        cartItems.add(newCartItem);
        numberOfArticles++;

        return false;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public CustomerWrapper getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerWrapper customer) {
        this.customer = customer;
    }

    public List<CartItemWrapper> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemWrapper> cartItems) {
        this.cartItems = cartItems;
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }

    public void setNumberOfArticles(int numberOfArticles) {
        this.numberOfArticles = numberOfArticles;
    }
}
