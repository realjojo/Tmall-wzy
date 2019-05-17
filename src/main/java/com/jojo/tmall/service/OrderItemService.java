package com.jojo.tmall.service;

import com.jojo.tmall.dao.OrderItemDAO;
import com.jojo.tmall.pojo.OrderItem;
import com.jojo.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    OrderItemDAO orderItemDAO;

    public Page4Navigator<OrderItem> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page pageFromJPA = orderItemDAO.findAll(pageable);
        return new Page4Navigator<OrderItem>(pageFromJPA,navigatePages);
    }

    public OrderItem getByOrderId(int oid) {
        return orderItemDAO.getByOrderId(oid);
    }

    public List<OrderItem> getAll() {
        return orderItemDAO.findAll();
    }
}
