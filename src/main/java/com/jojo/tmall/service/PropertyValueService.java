package com.jojo.tmall.service;

import com.jojo.tmall.dao.PropertyValueDAO;
import com.jojo.tmall.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService {

    @Autowired
    PropertyValueDAO propertyValueDAO;

    public void add(PropertyValue propertyValue) {
        propertyValueDAO.save(propertyValue);
    }

    public void addAll(List<PropertyValue> propertyValueList) {
        propertyValueDAO.saveAll(propertyValueList);
    }

    public void update(PropertyValue propertyValue) {
        propertyValueDAO.save(propertyValue);
    }
}
