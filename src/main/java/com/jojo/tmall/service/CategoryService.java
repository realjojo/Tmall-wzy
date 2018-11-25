package com.jojo.tmall.service;

import com.jojo.tmall.dao.CategoryDAO;
import com.jojo.tmall.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    /**
     * 首先创建一个 Sort 对象，表示通过 id 到排序， 然后通过 categoryDAO进行查询
     * 注： 这里抛弃了 CategoryService 接口加上 CategoryService 实现类的这种累赘的写法，
     * 而是直接使用 CategoryService 作为实现类来做
     * @return
     */
    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }
}
