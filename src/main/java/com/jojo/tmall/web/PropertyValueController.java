package com.jojo.tmall.web;

import com.jojo.tmall.pojo.PropertyValue;
import com.jojo.tmall.service.PropertyValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "PropertyValue", description = "PropertyValue相关的操作")
public class PropertyValueController {

    @Autowired
    PropertyValueService propertyValueService;

    @ApiOperation(value = "修改propertyValue")
    @PutMapping("/propertyvalues")
    public Object update(@RequestBody List<PropertyValue> propertyValue) {
        propertyValueService.update(propertyValue);
        return propertyValue;
    }

    @ApiOperation(value = "获取所有propertyValue")
    @GetMapping("/propertyvalues/{pid}")
    public List<PropertyValue> getAll(@PathVariable("pid") int pid) {
        return propertyValueService.getAll(pid);
    }
}
