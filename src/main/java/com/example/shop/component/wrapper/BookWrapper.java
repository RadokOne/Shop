package com.example.shop.component.wrapper;

public class BookWrapper extends ArticleWrapper {

    private String author;
    private BookCategoryWrapper bookCategory;

    public BookWrapper(int articleId, String name, String manufactor, Float price, String author, BookCategoryWrapper bookCategory) {
        super(articleId, name, manufactor, price);
        this.author = author;
        this.bookCategory = bookCategory;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCategoryWrapper getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategoryWrapper bookCategory) {
        this.bookCategory = bookCategory;
    }
}
