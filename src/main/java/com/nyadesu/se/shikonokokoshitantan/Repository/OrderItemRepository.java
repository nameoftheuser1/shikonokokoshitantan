package com.nyadesu.se.shikonokokoshitantan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nyadesu.se.shikonokokoshitantan.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
