package com.example.shop.component.wrapper.article;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BookWrapper.class, name = "book"),
        @JsonSubTypes.Type(value = CDWrapper.class, name = "cd")
})
public abstract class ArticleWrapper {

    private int articleId;
    private String name;
    private String manufactor;
    private Float price;
    private String type;

    public ArticleWrapper(int articleId, String name, String manufactor, Float price, String type) {
        this.articleId = articleId;
        this.name = name;
        this.manufactor = manufactor;
        this.price = price;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
