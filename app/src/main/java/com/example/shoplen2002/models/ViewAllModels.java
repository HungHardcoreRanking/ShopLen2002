package com.example.shoplen2002.models;

import java.io.Serializable;

public class ViewAllModels implements Serializable {
    String name;
    String price;
    String description;
    String img_url;
    String type;
    String rating;
    int total;
    public ViewAllModels() {
    }

    public ViewAllModels(String name, String price, String description, String img_url, String type, String rating, int total) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.img_url = img_url;
        this.type = type;
        this.rating = rating;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }
}
