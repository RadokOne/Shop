package com.example.shop.component.behavior;

import com.example.shop.component.wrapper.customer.CartWrapper;
import com.example.shop.component.wrapper.customer.CustomerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerClient customerClient;


    public CustomerWrapper createCustomerWithCard(CustomerWrapper customer){
        return customerClient.createCustomerWithCard(customer);
    }

    public CustomerWrapper getCustomer(int customerId){
        return customerClient.getCustomer(customerId);
    }

    public CartWrapper getCart(int customerId){
        return customerClient.getCart(customerId);
    }

    public void addArticleToCart(Integer customerId, String articleIdStr){
        customerClient.addArticleToCart(customerId, articleIdStr);
    }

    public void removeArticleFromCart(Integer customerId, int articleId){
        customerClient.removeArticleFromCart(customerId, articleId);
    }

    public void decrementArticleQuantityInCart(Integer customerId, Integer articleId){
        customerClient.decrementArticleQuantityInCart(customerId, articleId);
    }

    public CartWrapper checkoutCart(int customerId){
        return customerClient.checkoutCart(customerId);
    }

    public void deleteCustomer(int customerId){
        customerClient.deleteCustomer(customerId);
    }

}
