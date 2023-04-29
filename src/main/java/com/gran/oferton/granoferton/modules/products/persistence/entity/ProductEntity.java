package com.gran.oferton.granoferton.modules.products.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductEntity {

    @Id
    private String id;

    private String name;

    private Double price;

    @Column(name = "image_url")
    private String imageUrl;
    private Long stock;

    public Boolean getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Boolean promotion) {
        isPromotion = promotion;
    }

    @Column(name = "is_promo")
    private Boolean isPromotion;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", stock=" + stock +
                ", isPromo=" + isPromotion +
                ", description='" + description + '\'' +
                '}';
    }
}
