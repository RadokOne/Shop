package com.example.shop.component.wrapper;

public class CDWrapper extends ArticleWrapper{

    private String type;
    private String artist;

    public CDWrapper(int articleId, String name, String manufactor, Float price,String artist) {
        super(articleId, name, manufactor, price, "cd");
        this.artist = artist;

        this.type = "cd";
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
