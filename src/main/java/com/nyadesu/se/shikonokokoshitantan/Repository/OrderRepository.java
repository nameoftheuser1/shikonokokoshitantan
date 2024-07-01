package com.nyadesu.se.shikonokokoshitantan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyadesu.se.shikonokokoshitantan.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
