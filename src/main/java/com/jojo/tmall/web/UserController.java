package com.jojo.tmall.web;

import com.jojo.tmall.pojo.User;
import com.jojo.tmall.service.UserService;
import com.jojo.tmall.util.Page4Navigator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Api(tags = "User", description = "User相关的操作")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

//    @ApiOperation(value = "获取user列表")
    @GetMapping("/list")
    public Page4Navigator<User> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<User> page = userService.list(start, size, 5);
        return page;
    }
}
