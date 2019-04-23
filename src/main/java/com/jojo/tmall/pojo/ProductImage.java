package com.jojo.tmall.pojo;

import javax.persistence.*;

@Entity
@Table(name = "productimage")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    @Column(name = "type")
    private String type;

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
}
