package com.nyadesu.se.shikonokokoshitantan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyadesu.se.shikonokokoshitantan.model.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

}