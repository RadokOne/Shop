package com.example.shop.component;


import com.example.shop.component.behavior.ArticleService;
import com.example.shop.component.behavior.CustomerService;
import com.example.shop.component.behavior.OrderMessageSender;
import com.example.shop.component.wrapper.article.ArticleWrapper;
import com.example.shop.component.wrapper.customer.CartItemWrapper;
import com.example.shop.component.wrapper.customer.CartWrapper;
import com.example.shop.component.wrapper.customer.CustomerWrapper;
import com.example.shop.component.wrapper.order.OrderPositionWrapper;
import com.example.shop.component.wrapper.order.OrderWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Shop {

	private ArticleService articleService;
	private CustomerService customerService;

	private OrderMessageSender orderMessageSender;

	@Autowired
	public Shop(ArticleService articleService, CustomerService customerService, OrderMessageSender orderMessageSender) {
		this. articleService = articleService;
		this.customerService = customerService;
		this.orderMessageSender = orderMessageSender;
	}

	public Integer createCustomerWithCart(String name, String address) {
		CustomerWrapper customer = new CustomerWrapper(name, address);
		CartWrapper cart = new CartWrapper(customer);
		customer.setCart(cart);

		CustomerWrapper databaseCustomer = customerService.createCustomerWithCard(customer);
		customer.setCustomerId(databaseCustomer.getCustomerId());

		return customer.getCustomerId();
	}

	public void createArticle(ArticleWrapper article){
		articleService.createArticle(article);
	}

	public ArticleWrapper getArticle(int articleId) {
		return articleService.getArticle(articleId);
	}

	public void addArticleToCart(Integer customerId, Integer articleId) {
		ArticleWrapper foundArticle = getArticle(articleId);
		System.out.println("+++++++++++");
		System.out.println(foundArticle.getArticleId());
		System.out.println("+++++++++++");
		customerService.addArticleToCart(customerId, String.valueOf(foundArticle.getArticleId()));
	}

	public void decrementArticleQuantityInCart(Integer customerId, Integer articleId) {
		customerService.decrementArticleQuantityInCart(customerId, articleId);
	}

	public void removeArticleFromCart(Integer customerId, int articleId) {
		customerService.removeArticleFromCart(customerId, articleId);
	}


	public OrderWrapper checkOutCart(int customerId) throws JsonProcessingException {

		CartWrapper cart = customerService.getCart(customerId);

		List<OrderPositionWrapper> orderPositionList = new ArrayList<>();

		int i = 1;
		for (CartItemWrapper cartItem : cart.getCartItems()){
			float articlePrice = articleService.getArticle(cartItem.getArticleId()).getPrice();

			OrderPositionWrapper orderPosition = new OrderPositionWrapper(
					String.valueOf(i),
					cartItem.getArticleId(),
					articlePrice,
					cartItem.getQuantity()
			);
			i++;
			orderPositionList.add(orderPosition);
		}

		OrderWrapper order = new OrderWrapper(String.valueOf(System.currentTimeMillis()), customerId, orderPositionList);

		orderMessageSender.addOrder(order);

		return order;
	}

	public CartWrapper getCartForCustomer(Integer customerId) {
		return customerService.getCart(customerId);
	}

	public void deleteCustomer(int customerId){
		customerService.deleteCustomer(customerId);
	}
	public void deleteArticle(int articleId){
		articleService.deleteArticle(articleId);
	}

	public void deleteOrder(OrderWrapper orderWrapper) throws JsonProcessingException {
		orderMessageSender.deleteOrder(orderWrapper);
	}

}