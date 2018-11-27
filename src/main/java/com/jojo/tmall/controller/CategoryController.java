package com.jojo.tmall.controller;

import com.jojo.tmall.pojo.Category;
import com.jojo.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value="/categories")
    public List<Category> list() throws Exception {
        return categoryService.list();
    }
}
