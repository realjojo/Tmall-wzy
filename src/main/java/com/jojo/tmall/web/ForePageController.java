package com.jojo.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/6/6 21:25
 */
@Controller
public class ForePageController {

    @GetMapping(value = "/")
    public String index() {
        return "redirect:home_page";
    }

    @GetMapping(value = "/home_page")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/register_success_page")
    public String registerSuccess() {
        return "registerSuccess";
    }

    @GetMapping(value = "/register_page")
    public String register() {
        return "register";
    }

    @GetMapping(value = "/login_page")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/category_page")
    public String category() {
        return "category";
    }

    @GetMapping(value = "/product_page")
    public String product() {
        return "product";
    }

    @GetMapping(value = "/cart_page")
    public String cart() {
        return "cart";
    }

    @GetMapping(value = "/buy_page")
    public String buy() {
        return "buy";
    }

    @GetMapping(value = "/confirm_pay_page")
    public String confirmPay() {
        return "confirmPay";
    }

    @GetMapping(value = "/bought_page")
    public String bought() {
        return "bought";
    }

    @GetMapping(value = "/order_confirmed_page")
    public String orderConfirmed() {
        return "orderConfirmed";
    }

    @GetMapping(value = "/payed_page")
    public String payed() {
        return "payed";
    }

    @GetMapping(value = "/review_page")
    public String review() {
        return "review";
    }

    @GetMapping(value = "/search_result_page")
    public String searchResult() {
        return "searchResult";
    }

    @GetMapping(value = "/alipay_page")
    public String alipay() {
        return "alipay";
    }
}
