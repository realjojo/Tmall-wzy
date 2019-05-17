package com.jojo.tmall.service;

import com.jojo.tmall.dao.ProductImageDAO;
import com.jojo.tmall.pojo.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    @Autowired
    ProductImageDAO productImageDAO;

    public static final String TYPE_SINGLE = "single";

    public static final String TYPE_DETAIL = "detail";

    public List<ProductImage> list(int pid, String type) {
        return productImageDAO.findAllByProductIdAndType(pid, type);
    }

    public void add(ProductImage productImage) {
        productImageDAO.save(productImage);
    }

    public void delete(int id) {
        productImageDAO.deleteById(id);
    }

    public ProductImage get(int id) {
        return productImageDAO.getOne(id);
    }

}
