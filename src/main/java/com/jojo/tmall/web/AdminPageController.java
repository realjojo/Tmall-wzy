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
}
