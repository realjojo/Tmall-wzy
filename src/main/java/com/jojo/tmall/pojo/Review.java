package com.jojo.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/17 22:18
 */
@Entity
@Table(name = "review")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @ApiModelProperty(value = "id")
    private int id;

    @Column(name = "name")
//    @ApiModelProperty(value = "评价内容")
    private String content;

    @ManyToOne
    @JoinColumn(name = "uid")
//    @ApiModelProperty(value = "用户信息")
    private User user;

    @ManyToOne
    @JoinColumn(name = "pid")
//    @ApiModelProperty(value = "商品信息")
    private Product product;

    @Column(name = "createDate")
//    @ApiModelProperty(value = "评价创建时间")
    private Timestamp createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
