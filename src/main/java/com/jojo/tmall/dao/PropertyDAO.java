package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.Category;
import com.jojo.tmall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyDAO extends JpaRepository<Property, Integer> {
    Page<Property> findByCategory(Category category, Pageable pageable);
    List<Property> findAllByCategory_Id(int cid);
}
