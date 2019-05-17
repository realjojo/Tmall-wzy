package com.jojo.tmall.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "propertyvalue")
public class PropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pid")
    @ApiModelProperty(value = "对应商品信息")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ptid")
    @ApiModelProperty(value = "对应属性信息")
    private Property property;

    @Column(name = "value")
    @ApiModelProperty(value = "属性值")
    private String value;

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

    public void setProperty(Property property) {
        this.property = property;
    }

    public Property getProperty() {
        return property;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
