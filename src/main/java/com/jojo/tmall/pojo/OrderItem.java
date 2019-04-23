package com.jojo.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "oid")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @Column(name = "number")
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
