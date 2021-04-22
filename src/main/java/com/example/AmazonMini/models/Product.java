package com.example.AmazonMini.models;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private Boolean bestseller;
    private String image;
    private String cost;
    private String category;

    public Product() {
    }

    public Product(String id, String title, String description, Boolean bestseller, String image, String cost, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.bestseller = bestseller;
        this.image = image;
        this.cost = cost;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBestseller() {
        return bestseller;
    }

    public void setBestseller(Boolean bestseller) {
        this.bestseller = bestseller;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", bestseller=" + bestseller +
                ", image='" + image + '\'' +
                ", cost='" + cost + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
