package com.jojo.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping(value = "/admin")
    public String admin(){
        return "redirect:admin_category_list";
    }

    @GetMapping(value = "/admin_category_list")
    public String listCategory(){
        return "admin/listCategory";
    }

    @GetMapping(value = "/admin_category_edit")
    public String editCategory(){
        return "admin/EditCategory";
    }

    @GetMapping(value = "/admin_property_list")
    public String listProperty(){
        return "admin/listProperty";
    }

    @GetMapping(value = "/admin_property_edit")
    public String editProperty(){
        return "admin/EditProperty";
    }

    @GetMapping(value = "/admin_product_list")
    public String listProduct(){
        return "admin/listProduct";
    }

    @GetMapping(value = "/admin_product_edit")
    public String editProduct(){
        return "admin/EditProduct";
    }

    @GetMapping(value = "/admin_property_value_set")
    public String setProductProperty(){
        return "admin/setPropertyValue";
    }

    @GetMapping(value = "/admin_product_img_update")
    public String updateProductImage(){
        return "admin/updateProductImage";
    }

    @GetMapping(value = "/admin_user_list")
    public String listUser() {
        return "admin/listUser";
    }

    @GetMapping(value = "/admin_order_list")
    public String listOrder() {
        return "admin/listOrder";
    }
}
