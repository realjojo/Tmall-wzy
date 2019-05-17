package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDAO extends JpaRepository<OrderItem, Integer> {
    OrderItem getByOrderId(int oid);
}
