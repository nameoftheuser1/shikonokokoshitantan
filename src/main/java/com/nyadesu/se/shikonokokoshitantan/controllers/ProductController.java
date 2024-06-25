package com.nyadesu.se.shikonokokoshitantan.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nyadesu.se.shikonokokoshitantan.Repository.ProductRepository;
import com.nyadesu.se.shikonokokoshitantan.model.Product;

@RestController
public class ProductController {

    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return repo.findAll();
    }

    // public Product geProduct(Long id){
    // return repo.findById(id);
    // }

    @PostMapping("/product/create")
    public String create(@RequestBody Product newProduct) {
        repo.save(newProduct);
        return "A new product is added.";
    }

}
