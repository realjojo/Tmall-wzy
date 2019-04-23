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

    public void update(List<PropertyValue> propertyValue) {
        propertyValueDAO.saveAll(propertyValue);
    }

    public List<PropertyValue> getAll(int pid) {
        return propertyValueDAO.findAllByProductId(pid);
    }
}
