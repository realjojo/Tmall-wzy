package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Order;
import com.jojo.tmall.service.OrderService;
import com.jojo.tmall.util.Page4Navigator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Order", description = "Order相关的操作")
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "获取order列表")
    @GetMapping("/list")
    public Page4Navigator<Order> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<Order> page = orderService.list(start, size, 5);
        return page;
    }

    @ApiOperation(value = "更新发货时间")
    @PutMapping("/update")
    public void update(@RequestBody Order order) {
        System.out.println(order.toString());
        orderService.update(order);
    }

}
