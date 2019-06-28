package com.jojo.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @ApiModelProperty(value = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pid")
//    @ApiModelProperty(value = "订单详情：商品信息")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "oid")
//    @ApiModelProperty(value = "订单详情：订单信息")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "uid")
//    @ApiModelProperty(value = "订单详情：买家信息")
    private User user;

    @Column(name = "number")
//    @ApiModelProperty(value = "订单详情：购买数量")
    private int number;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
