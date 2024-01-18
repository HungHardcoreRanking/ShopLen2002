package com.example.shoplen2002.models;

public class CartModel {
    String username;
    String img_url;
    String productname;
    String price;
    String quantity;
    String total_price;

    public CartModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPrice() {
        return price;
    }
    public  String getImg_url(){return img_url;}

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }
    public void setImg_url(String img_url){this.img_url=img_url;}

    public CartModel(String username, String productname, String price, String quantity, String total_price, String img_url) {
        this.username = username;
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
        this.total_price = total_price;
        this.img_url=img_url;
    }
}
