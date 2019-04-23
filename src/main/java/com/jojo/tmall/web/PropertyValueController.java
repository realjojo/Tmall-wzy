package com.jojo.tmall.web;

import com.jojo.tmall.pojo.PropertyValue;
import com.jojo.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {

    @Autowired
    PropertyValueService propertyValueService;

    @PutMapping("/propertyvalues")
    public Object update(@RequestBody List<PropertyValue> propertyValue) {
        propertyValueService.update(propertyValue);
        return propertyValue;
    }

    @GetMapping("/propertyvalues/{pid}")
    public List<PropertyValue> getAll(@PathVariable("pid") int pid) {
        return propertyValueService.getAll(pid);
    }
}
