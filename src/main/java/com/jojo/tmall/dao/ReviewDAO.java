package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/17 22:24
 */
public interface ReviewDAO extends JpaRepository<Review, Integer> {
}
