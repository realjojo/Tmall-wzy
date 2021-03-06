package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.pojo.ProductImage;
import com.jojo.tmall.service.ProductImageService;
import com.jojo.tmall.util.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
//@Api(tags = "ProductImage", description = "ProductImage相关的操作")
@RequestMapping("/productimages")
public class ProductImageController {

    @Autowired
    ProductImageService productImageService;

//    @ApiOperation(value = "获取productImage列表")
    @GetMapping("/list/{pid}")
    public List<ProductImage> list(@PathVariable("pid") int pid, @RequestParam("type") String type) {
        return productImageService.list(pid, type);
    }

//    @ApiOperation(value = "增加productImage")
    @PostMapping("/add")
    public ProductImage add(ProductImage productImage, MultipartFile image, HttpServletRequest request) throws IOException {
        JSONObject jsonObject = JSONObject.fromObject(request.getParameter("pid"));
        Product p = (Product) JSONObject.toBean(jsonObject, Product.class);
        productImage.setProduct(p);
        productImageService.add(productImage);
        saveOrUpdateImageFile(productImage, image, request);
        return productImage;
    }

//    @ApiOperation(value = "删除productImage")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, @RequestParam("type") String type, HttpServletRequest request) throws Exception {
        ProductImage productImage = productImageService.get(id);
        productImageService.delete(id);
        File imageFolder= new File(request.getServletContext().getRealPath("img/product" + type.substring(5)));
        File file = new File(imageFolder, productImage.getId() + ".jpg");
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
        File file = new File(imageFolder, bean.getId() + ".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }
}
