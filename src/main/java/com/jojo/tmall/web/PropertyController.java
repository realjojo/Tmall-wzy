package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Property;
import com.jojo.tmall.service.PropertyService;
import com.jojo.tmall.util.Page4Navigator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Api(tags = "Property", description = "Property相关的操作")
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

//    @ApiOperation(value = "获取property列表")
    @GetMapping("/list/{cid}")
    public Page4Navigator<Property> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0")int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start < 0 ? 0 : start;
        Page4Navigator<Property> page = propertyService.list(cid, start, size, 5);
        return page;
    }

//    @ApiOperation(value = "获取所有property")
    @GetMapping("/get_all/{cid}")
    public List<Property> getAll(@PathVariable("cid") int cid) {
        List<Property> propertyList = propertyService.getAll(cid);
        return propertyList;
    }

//    @ApiOperation(value = "获取某个property")
    @GetMapping("/get/{id}")
    public Property get(@PathVariable("id") int id) throws Exception{
        return propertyService.get(id);
    }

//    @ApiOperation(value = "增加property")
    @PostMapping("/add")
    public Object add(@RequestBody Property property) throws Exception{
        propertyService.add(property);
        return property;
    }

//    @ApiOperation(value = "删除property")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) throws Exception{
        propertyService.delete(id);
        return null;
    }

//    @ApiOperation(value = "修改property")
    @PutMapping("/update")
    public Object update(@RequestBody Property property) throws Exception{
        propertyService.update(property);
        return property;
    }
}
