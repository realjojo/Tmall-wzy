package com.jojo.tmall.service;

import com.jojo.tmall.dao.CategoryDAO;
import com.jojo.tmall.pojo.Category;
import com.jojo.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page4Navigator<Category> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =categoryDAO.findAll(pageable);
        return new Page4Navigator<Category>(pageFromJPA,navigatePages); //TODO:<>里写Category与不写的区别
    }
}
