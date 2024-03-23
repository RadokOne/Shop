package com.example.shop.component;

import com.example.shop.component.wrapper.ArticleWrapper;
import com.example.shop.component.wrapper.BookCategoryWrapper;
import com.example.shop.component.wrapper.BookWrapper;
import com.example.shop.connectors.ArticleConnector;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.Set;

public class Catalog {

	private int catalogId;
	private Set<ArticleWrapper> articles;


	public Catalog() {
		articles = new HashSet<ArticleWrapper>();
		this.catalogId = 1;

		BookWrapper book1 = new BookWrapper(1,"Entwickeln von Web-Anwendungen", "Pinguin",23.0f, "Slotos", BookCategoryWrapper.POPULAR_SCIENCE);
		articles.add(book1);

		BookWrapper book2 = new BookWrapper(2,"Java for beginners", "for dummies",15.0f, "Mark", BookCategoryWrapper.POPULAR_SCIENCE);
		articles.add(book2);

		BookWrapper book3 = new BookWrapper(3,"Servlets", "Pinguin",22.0f, "Slotos", BookCategoryWrapper.POPULAR_SCIENCE);
		articles.add(book3);

	}
//
	public int getCatalogId() {
		return catalogId;
	}
//
	public Set<ArticleWrapper> getArticles() {
		return articles;
	}

	public void setArticles(Set<ArticleWrapper> articles) {
		this.articles = articles;
	}

	public ArticleWrapper getArticle(int articleId) {
		ArticleWrapper foundArticle = null;

		for (ArticleWrapper article : articles) {
			if (article.getArticleId() == articleId) {
				foundArticle = article;
				break;
			}
		}

		return foundArticle;
	}

}
