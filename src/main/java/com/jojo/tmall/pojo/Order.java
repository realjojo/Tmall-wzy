package com.jojo.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orderinfo")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @ApiModelProperty(value = "id")
    private int id;

    @Column(name = "orderCode")
//    @ApiModelProperty(value = "订单编号")
    private String orderCode;

    @Column(name = "address")
//    @ApiModelProperty(value = "收货地址")
    private String address;

    @Column(name = "post")
//    @ApiModelProperty(value = "收货邮编")
    private String post;

    @Column(name = "receiver")
//    @ApiModelProperty(value = "收货人")
    private String receiver;

    @Column(name = "mobile")
//    @ApiModelProperty(value = "收货手机号")
    private String mobile;

    @Column(name = "userMessage")
//    @ApiModelProperty(value = "买家备注信息")
    private String userMessage;

    @Column(name = "createDate")
//    @ApiModelProperty(value = "订单创建时间")
    private Timestamp createDate;

    @Column(name = "payDate")
//    @ApiModelProperty(value = "订单支付时间")
    private Timestamp payDate;

    @Column(name = "deliveryDate")
//    @ApiModelProperty(value = "订单发货时间")
    private Timestamp deliveryDate;

    @Column(name = "confirmDate")
//    @ApiModelProperty(value = "订单确认收货时间")
    private Timestamp confirmDate;

    @ManyToOne
    @JoinColumn(name = "uid")
//    @ApiModelProperty(value = "买家信息")
    private User user;

    @Column(name = "status")
//    @ApiModelProperty(value = "订单状态")
    private String status;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setConfirmDate(Timestamp confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Timestamp getConfirmDate() {
        return confirmDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
