package com.jojo.tmall.web;

import com.jojo.tmall.pojo.PropertyValue;
import com.jojo.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyValueController {

    @Autowired
    PropertyValueService propertyValueService;

    @PostMapping("/propertyvalues")
    public List<PropertyValue> addAll(List<PropertyValue> propertyValueList) {
        propertyValueService.addAll(propertyValueList);
        return propertyValueList;
    }

    @PutMapping("/propertyvalues")
    public Object update(PropertyValue propertyValue) {
        propertyValueService.update(propertyValue);
        return propertyValue;
    }
}
