package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyValueDAO extends JpaRepository<PropertyValue, Integer> {
    List<PropertyValue> findAllByProductId(int pid);
}
