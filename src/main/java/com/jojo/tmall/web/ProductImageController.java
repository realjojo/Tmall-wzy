package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.pojo.ProductImage;
import com.jojo.tmall.service.ProductImageService;
import com.jojo.tmall.util.ImageUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class ProductImageController {

    @Autowired
    ProductImageService productImageService;

    @GetMapping("/productimages/{pid}")
    public List<ProductImage> list(@PathVariable("pid") int pid, @RequestParam("type") String type) {
        return productImageService.list(pid, type);
    }

    @PostMapping("/productimages")
    public ProductImage add(ProductImage productImage, MultipartFile image, HttpServletRequest request) throws IOException {
        JSONObject jsonObject = JSONObject.fromObject(request.getParameter("pid"));
        Product p = (Product) JSONObject.toBean(jsonObject, Product.class);
        productImage.setProduct(p);
        productImageService.add(productImage);
        saveOrUpdateImageFile(productImage, image, request);
        return productImage;
    }

    @DeleteMapping("/productimages/{id}")
    public String delete(@PathVariable("id") int id, @RequestParam("type") String type, HttpServletRequest request) throws Exception {
        ProductImage p = productImageService.get(id);
        productImageService.delete(id);
        File  imageFolder= new File(request.getServletContext().getRealPath("img/product" + type));
        File file = new File(imageFolder,p.getProduct().getId() + "_" + p.getId() + p.getType() + ".jpg");
        file.delete();
        return null;
    }

    private void saveOrUpdateImageFile(ProductImage bean, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder;
        if(bean.getType().equals(ProductImageService.TYPE_SINGLE)) {
            imageFolder= new File(request.getServletContext().getRealPath("img/productsingle"));
        } else {
            imageFolder= new File(request.getServletContext().getRealPath("img/productdetail"));
        }
        File file = new File(imageFolder,bean.getProduct().getId() + "_" + bean.getId() + bean.getType() + ".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }
}
