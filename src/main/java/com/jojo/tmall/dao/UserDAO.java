package com.jojo.tmall.dao;

import com.jojo.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByToken(String token);
    User findByName(String name);
    User findByNameAndPassword(String name, String password);
}
