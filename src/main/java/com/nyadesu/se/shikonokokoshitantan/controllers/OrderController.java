package com.nyadesu.se.shikonokokoshitantan.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nyadesu.se.shikonokokoshitantan.NotFoundException.OrderNotFoundException;
import com.nyadesu.se.shikonokokoshitantan.Repository.OrderRepository;
import com.nyadesu.se.shikonokokoshitantan.model.Order;

@RestController
public class OrderController {

    private final OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return repo.findAll();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new OrderNotFoundException(id));
    }

    @PostMapping("/order/create")
    public String create(@RequestBody Order newOrder) {
        repo.save(newOrder);
        return "A new order is added.";
    }

    @DeleteMapping("/order/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "The order is deleted!";
    }

}
