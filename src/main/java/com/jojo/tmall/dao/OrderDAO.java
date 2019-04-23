package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {
}
