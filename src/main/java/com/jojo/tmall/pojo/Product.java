package com.jojo.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @ApiModelProperty(value = "id")
    private int id;

    @Column(name = "name")
//    @ApiModelProperty(value = "商品名称")
    private String name;

    @Column(name = "subTitle")
//    @ApiModelProperty(value = "商品小标题")
    private String subTitle;

    @Column(name = "originalPrice")
//    @ApiModelProperty(value = "商品原价")
    private float originalPrice;

    @Column(name = "promotePrice")
//    @ApiModelProperty(value = "商品促销价")
    private float promotePrice;

    @Column(name = "stock")
//    @ApiModelProperty(value = "商品库存")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "cid")
//    @ApiModelProperty(value = "商品对应分类信息")
    private Category category;

    @Column(name = "createDate")
//    @ApiModelProperty(value = "商品创建时间")
    private Date createDate;

    @Transient
    private ProductImage firstProductImage; //@Transient表示这是一个瞬时字段，不会被保存到数据库中
    @Transient
    private List<ProductImage> productSingleImages;
    @Transient
    private List<ProductImage> productDetailImages;
    @Transient
    private int reviewCount;
    @Transient
    private int saleCount;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setPromotePrice(float promotePrice) {
        this.promotePrice = promotePrice;
    }

    public float getPromotePrice() {
        return promotePrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public ProductImage getFirstProductImage() {
        return firstProductImage;
    }

    public void setFirstProductImage(ProductImage firstProductImage) {
        this.firstProductImage = firstProductImage;
    }

}
