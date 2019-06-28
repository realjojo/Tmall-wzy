package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Category;
import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.pojo.ResponseEnum;
import com.jojo.tmall.pojo.User;
import com.jojo.tmall.service.CategoryService;
import com.jojo.tmall.service.ProductImageService;
import com.jojo.tmall.service.ProductService;
import com.jojo.tmall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/6/6 21:26
 */
@RestController
//@Api(tags = "foreREST", description = "前端接口")
public class ForeRESTController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;

    @GetMapping("/forehome")
    public Object home() {
        List<Category> cs = categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
        categoryService.removeCategoryFromProduct(cs);
        return cs;
    }

    @PostMapping("/foreregister")
    public User register(@RequestBody User user) {
        boolean exist = userService.isExit(user.getName());
        if (exist) {
            return null;
        } else {
            userService.add(user);
            return user;
        }
    }

    @PostMapping("/forelogin")
    public User login(@RequestBody User user) throws Exception {
        return userService.userLogin(user);
    }

    @GetMapping("/forelogout")
    public void logout(@RequestParam(value = "token", defaultValue = "noToken") String token) throws Exception {
        userService.userLogout(token);
    }

//    public String product(@RequestBody Product product) {
//        t2p(product);
//
//        productImageService.setFirstProductImage(product);
//        productSingleImages = productImageService.list("product", product, "type", ProductImageService.type_single);
//        productDetailImages = productImageService.list("product", product, "type", ProductImageService.type_detail);
//        product.setProductSingleImages(productSingleImages);
//        product.setProductDetailImages(productDetailImages);
//
//        propertyValues = propertyValueService.listByParent(product);
//
//        reviews = reviewService.listByParent(product);
//
//        productService.setSaleAndReviewNumber(product);
//
//        return "";
//    }

}
