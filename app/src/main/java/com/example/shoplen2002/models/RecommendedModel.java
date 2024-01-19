package com.example.shoplen2002.models;

public class RecommendedModel {
    String name;
    String img_url;
    String rating;
    String description;

    String price;

    public RecommendedModel(){

    }

    public RecommendedModel(String name, String img_url, String rating, String description, String price) {
        this.name = name;
        this.img_url = img_url;
        this.rating = rating;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
