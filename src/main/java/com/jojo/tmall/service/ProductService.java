package com.jojo.tmall.service;

import com.jojo.tmall.dao.ProductDAO;
import com.jojo.tmall.pojo.Category;
import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;
    @Autowired
    CategoryService categoryService;

    public Page4Navigator<Product> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Product> pageFromJPA = productDAO.findByCategory(category, pageable);
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public Product get(int id) {
        return productDAO.getOne(id);
    }

    public void add(Product product) {
        productDAO.save(product);
    }

    public void update(Product product) {
        productDAO.save(product);
    }

    public void delete(int id) {
        productDAO.deleteById(id);
    }
}
