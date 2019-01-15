package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Property;
import com.jojo.tmall.service.PropertyService;
import com.jojo.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0")int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start < 0 ? 0 : start;
        Page4Navigator<Property> page = propertyService.list(cid, start, size, 5);
        return page;
    }

    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id") int id) throws Exception{
        return propertyService.get(id);
    }

    @PostMapping("/properties")
    public Object add(@RequestBody Property property) throws Exception{
        propertyService.add(property);
        return property;
    }

    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id") int id) throws Exception{
        propertyService.delete(id);
        return null;
    }

    @PutMapping("/properties")
    public Object update(@RequestBody Property property) throws Exception{
        propertyService.update(property);
        return property;
    }
}
