package com.jojo.tmall.web;

import com.jojo.tmall.pojo.*;
import com.jojo.tmall.service.*;
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
    @Autowired
    PropertyValueService propertyValueService;

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

    @DeleteMapping("/forelogout")
    public void logout(@RequestParam(value = "token", defaultValue = "noToken") String token) throws Exception {
        userService.userLogout(token);
    }

    @GetMapping("/foreproduct/{pid}")
    public Product product(@PathVariable("pid") int pid) {
        Product product = productService.get(pid);
        productImageService.setFirstProductImage(product);
        //todo
        product.setProductSingleImages(productImageService.list(pid, ProductImageService.TYPE_SINGLE));
        product.setProductDetailImages(productImageService.list(pid, ProductImageService.TYPE_DETAIL));
        productService.setSaleAndReviewNumber(product);
        System.out.println("myyyyyy:" + product);
        return product;
    }

    @GetMapping("/forepropertyvalues/{pid}")
    public List<PropertyValue> getPropertyValues(@PathVariable("pid") int pid) {
        List<PropertyValue> propertyValueList = propertyValueService.getAll(pid);
        return propertyValueList;
    }

//    @GetMapping("/forechecklogin")
//    public boolean checkLogin(@RequestBody User user) {
//        return userService.checkLogin(user);
//    }

//    @GetMapping("/forecategory/{cid}")
//    public String category(@PathVariable("cid") int cid) {
//        Category category = categoryService.get(cid);
//        productService.fill(category);
//        productService.setSaleAndReviewNumber(category.getProducts());
//
//        if (sort != null) {
//            switch (sort) {
//                case "review"://评价数量多的放前面
//                    Collections.sort(category.getProducts(), new Comparator<Product>() {
//                        @Override
//                        public int compare(Product o1, Product o2) {
//                            return o2.getReviewCount() - o1.getReviewCount();
//                        }
//                    });
//                    break;
//                case "date"://新创建的放前面，即创建日期比较晚的在前
//                    Collections.sort(category.getProducts(), ((o1, o2) -> o1.getCreateDate().compareTo(o2.getCreateDate())));
//                    break;
//                case "saleCount"://销量高的放前面
//                    Collections.sort(category.getProducts(), ((o1, o2) -> o2.getSaleCount() - o1.getSaleCount()));
//                    break;
//                case "price"://价格低的放前面
//                    Collections.sort(category.getProducts(), ((o1, o2) -> (int) (o1.getPromotePrice() - o2.getPromotePrice())));
//                    break;
//                case "all"://把 销量*评价 高的放前面
//                    Collections.sort(category.getProducts(), ((o1, o2) -> o2.getReviewCount() * o2.getSaleCount() - o1.getReviewCount() * o1.getSaleCount()));
//                    break;
//            }
//        }
//        return "category.jsp";
//    }
}