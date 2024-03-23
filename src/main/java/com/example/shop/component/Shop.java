package com.example.shop.component;

import com.example.shop.component.behavior.ArticleService;
import com.example.shop.component.wrapper.article.ArticleWrapper;

import java.util.List;


public class Shop {
	private ArticleService shopService;
	private List<Integer> customerId;


	public Shop() {
		//customers = new HashMap<Integer, Customer>();
		shopService = new ArticleService();

	}

//	public Integer createCustomerWithCart() {
//		Cart cart = new Cart();
//
//		Customer customer = new Customer(cart);
//
//		customers.put(customer.getCustomerId(), customer);
//
//		return customer.getCustomerId();
//	}

	public ArticleWrapper getArticle(int articleId) {
		// Delegation
		return shopService.getArticle(articleId);
	}



//	public void removeArticleFromCart(Integer customerId, int articleId) {
//		// Delegation
//		Cart cart = customers.get(customerId).getCart();
//
//		cart.deleteCartItem(articleId);
//	}

//	public void addArticleToCart(Integer customerId, Integer articleId) {
//		Article foundArticle = getArticle(articleId);
//
//		Cart cart = customers.get(customerId).getCart();
//
//		cart.addCartItem(foundArticle);
//	}

//	public void decrementArticleQuantityInCart(Integer customerId,
//			Integer articleId) {
//		Cart cart = customers.get(customerId).getCart();
//
//		cart.decrementArticleQuantity(articleId);
//	}

//	public Order checkOutCart(int customerId) {
//
//		Customer customer = customers.get(customerId);
//		Cart cart = customer.getCart();
//
//		Order order = new Order(1);
//
//		int i = 1;
//
//		for (CartItem cartItem : cart.getCartItems()) {
//			OrderPosition orderPosition = new OrderPosition(i++);
//			orderPosition.setArticle(cartItem.getArticle());
//			orderPosition.setArticleQuantity(cartItem.getQuantity());
//			order.addOrderPosition(orderPosition);
//		}
//
//		customer.addOrder(order);
//
//		return order;
//	}

//	public Cart getCartForCustomer(Integer customerId) {
//		return customers.get(customerId).getCart();
//	}

}