package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage, Integer> {
    List<ProductImage> findAllByProductIdAndType(int pid, String type);
}
