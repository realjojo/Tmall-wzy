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
import java.util.Optional;

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

    public void add(Category category) {
        categoryDAO.save(category);
    }

    public void delete(int id) {
        categoryDAO.deleteById(id);
    }

    /**
     * Optional类是一个可以为null的容器对象
     * 如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象
     * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null
     * Optional提供很多有用的方法，这样我们就不用显式进行空值检测
     * Optional 类的引入很好的解决空指针异常
     * @param id
     * @return
     */
    public Optional<Category> get(int id) {
        Optional<Category> c= categoryDAO.findById(id);
        return c;
    }

    public void update(Category category) {
        categoryDAO.save(category);
    }
}
