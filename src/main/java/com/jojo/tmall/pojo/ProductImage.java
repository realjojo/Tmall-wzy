package com.jojo.tmall.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "productimage")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pid")
    @ApiModelProperty(value = "对应商品信息")
    private Product product;

    @Column(name = "type")
    @ApiModelProperty(value = "商品图片类别")
    private String type;

    @Column(name = "name")
    @ApiModelProperty(value = "商品图片名称")
    private String name;

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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
