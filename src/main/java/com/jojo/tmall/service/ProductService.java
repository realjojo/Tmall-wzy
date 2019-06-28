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

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;

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

    public void fill(List<Category> categories) {
        for (Category category : categories) {
            fill(category);
        }
    }

    public void fill(Category category) {
        List<Product> products = productDAO.findAllByCategory(category);
        for (Product product : products) {
            productImageService.setFirstProductImage(product);
        }
        category.setProducts(products);
    }

    public void fillByRow(List<Category> categories) {
        int productNumberEachRow = 8;
        for (Category category : categories) {
            List<Product> products = category.getProducts();  //对每个category获取其所有的product集合,下面被拆成多行
            List<List<Product>> productsByRow = new ArrayList<>();
            for (int i = 0; i < products.size(); i += productNumberEachRow) {
                int size = i + productNumberEachRow;
                size = size > products.size() ? products.size() : size;  //size取products.size()和i+productNumberEachRow之小
                List<Product> productsOfEachRow = products.subList(i, size);  //从所有product集合中截取i~size
                productsByRow.add(productsOfEachRow);
            }
            category.setProductsByRow(productsByRow);
        }
    }

}
