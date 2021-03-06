package com.jojo.tmall.service;

import com.jojo.tmall.dao.ReviewDAO;
import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/17 22:27
 */
@Service
public class ReviewService {

    @Autowired
    ReviewDAO reviewDAO;

    public Review get(int id) {
        return reviewDAO.getOne(id);
    }

    public List<Review> listByProduct(Product product) {
        return reviewDAO.findAllByProduct(product);
    }

}
