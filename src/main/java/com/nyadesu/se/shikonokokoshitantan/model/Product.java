package com.nyadesu.se.shikonokokoshitantan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String product_name;
    private String generic_name;
    private String category;
    private String product_description;
    private double price;

    public Product() {}

    public Product(String product_name, String generic_name, String category, String product_description, double price) {
        this.product_name = product_name;
        this.generic_name = generic_name;
        this.category = category;
        this.product_description = product_description;
        this.price = price;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
