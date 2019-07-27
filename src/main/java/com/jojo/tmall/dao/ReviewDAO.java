package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/17 22:24
 */
public interface ReviewDAO extends JpaRepository<Review, Integer> {
    List<Review> findAllByProduct(Product product);
}
