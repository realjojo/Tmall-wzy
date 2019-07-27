package com.jojo.tmall.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.jojo.tmall.dao.UserDAO;
import com.jojo.tmall.exception.GlobalExceptionHandler;
import com.jojo.tmall.pojo.ResponseEnum;
import com.jojo.tmall.pojo.User;
import com.jojo.tmall.util.JWTUtil;
import com.jojo.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    private static final String mysqlSdfPatternString = "yyyy-MM-dd HH:mm:ss";

    public Page4Navigator<User> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page pageFromJPA = userDAO.findAll(pageable);
        return new Page4Navigator<User>(pageFromJPA,navigatePages);
    }

    public void add(User user) {
        userDAO.save(user);
    }

    public boolean isExit(String name) {
        User u = userDAO.findByName(name);
        if (u != null) {
            return true;
        }
        return false;
    }

    public User userLogin(User user) throws Exception {
        SimpleDateFormat mysqlSdf = new java.text.SimpleDateFormat(mysqlSdfPatternString);
        User u = userDAO.findByNameAndPassword(user.getName(), user.getPassword());
        if(u == null) {
            throw new GlobalExceptionHandler(ResponseEnum.LOGIN_FAILED.getCode(), ResponseEnum.LOGIN_FAILED.getMessage());
        } else {
            //采用jwt获得token
            Date createTime = new Date();
            //每七天需要重新登录(可以直接将过期时间写入token，解析token时即可判断是否过期，而无需在代码中判断)
            Date expireTime = new Date(createTime.getTime() + 1000 * 60 * 60 * 24 * 7);
            Map<String, String> content = new HashMap<>();
            content.put("uid", u.getId() + "");
            String token = JWTUtil.createJWT(content, "Tmall_Fore_token", createTime, expireTime);
            u.setTokenCreateAt(mysqlSdf.format(createTime));
            u.setToken(token);
            //更新数据库token_create_at，之后每次鉴权需要查看数据库查看自己的token是否是最新的
            userDAO.save(u);
        }
        return u;
    }

    public void userLogout(String token) throws Exception {
        SimpleDateFormat mysqlSdf = new java.text.SimpleDateFormat(mysqlSdfPatternString);
        if (Objects.equals(token, "noToken") || token == null) {
            throw new GlobalExceptionHandler(ResponseEnum.DO_NOT_LOGIN.getCode(), ResponseEnum.DO_NOT_LOGIN.getMessage());
        }
        Date now = new Date();
        DecodedJWT jwt = JWTUtil.phraseJWT(token, "Tmall_Fore_token", ResponseEnum.INVALID_USER_TOKEN.getMessage());
        User user = userDAO.findByToken(token);
        //数据库中token创建时间字段为空，说明用户已经注销登陆
        if (user == null)
            throw new GlobalExceptionHandler(ResponseEnum.DO_NOT_LOGIN.getCode(), ResponseEnum.DO_NOT_LOGIN.getMessage());
        else if (jwt.getIssuedAt().getTime() != mysqlSdf.parse(user.getTokenCreateAt()).getTime())
            throw new GlobalExceptionHandler(ResponseEnum.ALREADY_LOGIN.getCode(), ResponseEnum.ALREADY_LOGIN.getMessage());
        else if (jwt.getExpiresAt().getTime() < now.getTime())
            throw new GlobalExceptionHandler(ResponseEnum.EXPIRED_USER_TOKEN.getCode(), ResponseEnum.EXPIRED_USER_TOKEN.getMessage());
        else {
            user.setTokenCreateAt(null);
            user.setToken(null);
        }
        userDAO.save(user);
    }

//    public boolean checkLogin(User user) {
//        User u = userDAO.findByNameAndPassword(user.getName(), user.getPassword());
//        if(u == null) {
//            return false;
//        } else {
//            String token = u.getToken();
//            //todo: token_create_at 时间是否超时
//            if(token == null || token == "") {
//                return false;
//            } else {
//
//            }
//        }
//    }

}
