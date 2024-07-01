package com.nyadesu.se.shikonokokoshitantan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertbl")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Double totalAmount;
    private String Status;

    Order() {
    }

    public Order(Long userId, Double totalAmount, String status) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        Status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Long getId() {
        return id;
    }

}
