package com.gran.oferton.granoferton.modules.products.persistence.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductEntity {

    @Id
    private String id;

    private String name;

    private Double price;

    @Nullable
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
    @Nullable
    private Boolean isPromotion;

    @Nullable
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    public Boolean getPromotion() {
        return isPromotion;
    }

    public void setPromotion(Boolean promotion) {
        isPromotion = promotion;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

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
