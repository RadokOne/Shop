package com.example.shop.component.wrapper.order;

public class OrderPositionWrapper {
    private String positionId;
    private Integer articleId;
    private Float articlePrice;
    private int articleQuantity;

    public OrderPositionWrapper(String positionId, Integer articleId, Float articlePrice, int articleQuantity) {
        this.positionId = positionId;
        this.articleId = articleId;
        this.articlePrice = articlePrice;
        this.articleQuantity = articleQuantity;
    }

    public OrderPositionWrapper() {
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Float getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(Float articlePrice) {
        this.articlePrice = articlePrice;
    }

    public int getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(int articleQuantity) {
        this.articleQuantity = articleQuantity;
    }
}
