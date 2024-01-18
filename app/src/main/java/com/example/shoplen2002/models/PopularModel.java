package com.example.shoplen2002.models;

public class PopularModel {
    String name;
    String description;
    String rating;
    String discount;
//    String type;
    String img_url;

    public PopularModel(){
    }

    public PopularModel(String name, String description, String rating, String discount, String img_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.discount = discount;
        this.img_url = img_url;
//        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getDiscount() {
        return discount;
    }

//    public String getType() {
//        return type;
//    }

    public String getImg_url() {
        return img_url;
    }


}




