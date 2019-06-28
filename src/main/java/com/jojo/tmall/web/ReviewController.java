package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Review;
import com.jojo.tmall.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/17 22:29
 */
@RestController
//@Api(tags = "Review", description = "Review相关的操作")
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

//    @ApiOperation(value = "根据id获取评价内容")
    @GetMapping("/get/{id}")
    public Review get(@PathVariable("id") int id) {
        return reviewService.get(id);
    }

}
