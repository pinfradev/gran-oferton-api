package com.gran.oferton.granoferton.modules.products.domain.dto;

public class Product {

    private String id;

    private String imageUrl;

    private String productName;
    private double price;
    private int stock;
    private boolean isPromotion;


    private String description;


    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(boolean promotion) {
        isPromotion = promotion;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
