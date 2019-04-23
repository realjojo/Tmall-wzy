package com.jojo.tmall.web;

import com.jojo.tmall.pojo.OrderItem;
import com.jojo.tmall.service.OrderItemService;
import com.jojo.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/orderitems")
    public Page4Navigator<OrderItem> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<OrderItem> page = orderItemService.list(start, size, 5);
        return page;
    }

    @GetMapping("/orderitems/{oid}")
    public OrderItem getByOrderId(@PathVariable("oid") int oid) {
        return orderItemService.getByOrderId(oid);
    }

//    @GetMapping("/orderitems")
//    public List<OrderItem> getAll() {
//        return orderItemService.getAll();
//    }
}
