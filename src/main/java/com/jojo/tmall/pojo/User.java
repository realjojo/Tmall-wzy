package com.jojo.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @ApiModelProperty(value = "id")
    private int id;

    @Column(name = "name")
//    @ApiModelProperty(value = "用户名")
    private String name;

    @Column(name = "password")
//    @ApiModelProperty(value = "用户密码")
    private String password;

    @Column(name = "salt")
//    @ApiModelProperty(value = "用户salt值")
    private String salt;

    @Column(name = "token_create_at")
//    @ApiModelProperty(value = "token生成时间")
    private String tokenCreateAt;

    @Column(name = "token")
//    @ApiModelProperty(value = "用户登录token")
    private String token;

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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getTokenCreateAt() {
        return tokenCreateAt;
    }

    public void setTokenCreateAt(String tokenCreateAt) {
        this.tokenCreateAt = tokenCreateAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
