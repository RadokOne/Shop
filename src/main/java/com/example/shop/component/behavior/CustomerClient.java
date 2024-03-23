package com.example.shop.component.behavior;

import com.example.shop.component.wrapper.customer.CartWrapper;
import com.example.shop.component.wrapper.customer.CustomerWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("customer-service")
public interface CustomerClient {
    @PostMapping(value = "/customer/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerWrapper createCustomerWithCard(@RequestBody CustomerWrapper customer);

    @GetMapping("/customer/{customerId}")
    public CustomerWrapper getCustomer(@PathVariable int customerId);

    @GetMapping("/customer/{customerId}/cart")
    public CartWrapper getCart(@PathVariable int customerId);

    @PostMapping("/customer/{customerId}/add")
    public void addArticleToCart(@PathVariable Integer customerId, @RequestBody String articleIdStr);

    @DeleteMapping("/customer/{customerId}/removeArticle/{articleId}")
    public void removeArticleFromCart(@PathVariable Integer customerId, @PathVariable int articleId);

    @DeleteMapping("/customer/{customerId}/decrementQuantity/{articleId}")
    public void decrementArticleQuantityInCart(@PathVariable Integer customerId, @PathVariable Integer articleId);

    @GetMapping("/customer/{customerId}/checkoutCart")
    public CartWrapper checkoutCart(@PathVariable  int customerId);

    @DeleteMapping("/customer/{customerId}/delete")
    public void deleteCustomer(@PathVariable int customerId);

}
