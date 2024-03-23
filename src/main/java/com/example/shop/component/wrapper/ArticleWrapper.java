package com.example.shop.component.wrapper;

public abstract class ArticleWrapper {

    private int articleId;
    private String name;
    private String manufactor;
    private Float price;

    public ArticleWrapper(int articleId, String name, String manufactor, Float price) {
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
