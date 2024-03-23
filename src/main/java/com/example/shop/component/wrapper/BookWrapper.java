package com.example.shop.component.wrapper;

public class BookWrapper extends ArticleWrapper {

    private String type;
    private String author;
    private BookCategoryWrapper bookCategory;

    public BookWrapper(int articleId, String name, String manufactor, Float price, String author, BookCategoryWrapper bookCategory, String type) {
        super(articleId, name, manufactor, price, "book");
        this.author = author;
        this.bookCategory = bookCategory;

        this.type = type;
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
