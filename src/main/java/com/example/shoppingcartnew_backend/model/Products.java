package com.example.shoppingcartnew_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")

public class Products {

    @Id
    @GeneratedValue
    private int id;
    private String productname;
    private String image;
    private String category;
    private String description;

    private int price;

    public Products() {
    }


    public Products(int id, String productname, String image, String category, String description, int price) {
        this.id = id;
        this.productname = productname;
        this.image = image;
        this.category = category;
        this.description = description;
        this.price = price;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
