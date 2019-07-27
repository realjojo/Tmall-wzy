package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.OrderItem;
import com.jojo.tmall.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem, Integer> {
    OrderItem getById(int oid);
    List<OrderItem> findAllByProduct(Product product);
}
