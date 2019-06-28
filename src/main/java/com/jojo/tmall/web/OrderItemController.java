package com.jojo.tmall.web;

import com.jojo.tmall.pojo.OrderItem;
import com.jojo.tmall.service.OrderItemService;
import com.jojo.tmall.util.Page4Navigator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
//@Api(tags = "OrderItem", description = "OrderItem相关的操作")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

//    @ApiOperation(value = "获取orderItem列表")
    @GetMapping("/list")
    public Page4Navigator<OrderItem> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<OrderItem> page = orderItemService.list(start, size, 5);
        return page;
    }

//    @ApiOperation(value = "获取某个orderItem")
    @GetMapping("/get/{oid}")
    public OrderItem getByOrderId(@PathVariable("oid") int oid) {
        return orderItemService.getByOrderId(oid);
    }

//    @ApiOperation(value = "获取所有orderItem")
    @GetMapping("/all")
    public List<OrderItem> getAll() {
        return orderItemService.getAll();
    }

}
