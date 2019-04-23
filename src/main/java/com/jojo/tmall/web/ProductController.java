package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.service.ProductService;
import com.jojo.tmall.util.ImageUtil;
import com.jojo.tmall.util.Page4Navigator;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/categories/{cid}/products")
    public Page4Navigator<Product> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<Product> page = productService.list(cid, start, size, 5);
        return page;
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id) {
        return productService.get(id);
    }

    @PostMapping("/products")
    public Object add(MultipartFile image, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = JSONObject.fromObject(request.getParameter("product"));
        Product p = (Product) JSONObject.toBean(jsonObject, Product.class);
        productService.add(p);
        saveOrUpdateImageFile(p, image, request);
        return p;
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable("id") int id) {
        productService.delete(id);
        return null;
    }

    @PutMapping("/products")
    public Object update(@RequestBody Product product) throws Exception {
        productService.update(product);
        return product;
    }

    private void saveOrUpdateImageFile(Product bean, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/productsingle"));
        File file = new File(imageFolder,bean.getId() + "_0single.jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }
}
