package com.jojo.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "orderCode")
    private String orderCode;

    @Column(name = "address")
    private String address;

    @Column(name = "post")
    private String post;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "userMessage")
    private String userMessage;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "payDate")
    private Date payDate;

    @Column(name = "deliveryDate")
    private Date deliveryDate;

    @Column(name = "confirmDate")
    private Date confirmDate;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @Column(name = "status")
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

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public Date getConfirmDate() {
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
