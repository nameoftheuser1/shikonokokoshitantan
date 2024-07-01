package com.nyadesu.se.shikonokokoshitantan.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nyadesu.se.shikonokokoshitantan.NotFoundException.OrderItemNotFoundException;
import com.nyadesu.se.shikonokokoshitantan.Repository.OrderItemRepository;
import com.nyadesu.se.shikonokokoshitantan.model.OrderItem;

@RestController
public class OrderItemController {

    private final OrderItemRepository repo;

    public OrderItemController(OrderItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/order-items")
    public List<OrderItem> getOrderItems() {
        return repo.findAll();
    }

    @GetMapping("/order-item/{id}")
    public OrderItem getOrderItem(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new OrderItemNotFoundException(id));
    }

    @PostMapping("/order-item/create")
    public String create(@RequestBody OrderItem newOrderItem) {
        repo.save(newOrderItem);
        return "A new order item is added.";
    }

    @DeleteMapping("/order-item/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "The order item is deleted!";
    }

}
