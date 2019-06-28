package com.jojo.tmall.service;

import com.jojo.tmall.dao.ProductImageDAO;
import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.pojo.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    @Autowired
    ProductImageDAO productImageDAO;

    public static final String TYPE_SINGLE = "type_single";
    public static final String TYPE_DETAIL = "type_detail";

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

    public void setFirstProductImage(Product product) {
        if (product.getFirstProductImage() == null) {
            //取得productImage.class中对应product和type的所有productImage对象，并把第一个设置给product
            List<ProductImage> productImages = productImageDAO.findAllByProductIdAndType(product.getId(), TYPE_SINGLE);
            if (!productImages.isEmpty()) {
                ProductImage productImage = productImages.get(0);
                productImage.setProduct(null);
                product.setFirstProductImage(productImage);
            }
        }
    }

}
