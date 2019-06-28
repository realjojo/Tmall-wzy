package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Product;
import com.jojo.tmall.pojo.ProductImage;
import com.jojo.tmall.service.ProductService;
import com.jojo.tmall.util.ImageUtil;
import com.jojo.tmall.util.Page4Navigator;
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

@RestController
//@Api(tags = "Product", description = "Product相关的操作")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

//    @ApiOperation(value = "获取product列表")
    @GetMapping("/list/{cid}")
    public Page4Navigator<Product> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<Product> page = productService.list(cid, start, size, 5);
        return page;
    }

//    @ApiOperation(value = "获取某个product")
    @GetMapping("/get/{id}")
    public Product get(@PathVariable("id") int id) {
        return productService.get(id);
    }

//    @ApiOperation(value = "增加product")
    @PostMapping("/add")
    public Object add(@RequestBody Product product) throws Exception {
        productService.add(product);
        return product;
    }

//    @ApiOperation(value = "删除product")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        productService.delete(id);
        return null;
    }

//    @ApiOperation(value = "修改product")
    @PutMapping("/update")
    public Object update(@RequestBody Product product) throws Exception {
        productService.update(product);
        return product;
    }

//    private void saveOrUpdateImageFile(ProductImage bean, MultipartFile image, HttpServletRequest request) throws IOException {
//        File imageFolder= new File(request.getServletContext().getRealPath("img/productsingle"));
//        File file = new File(imageFolder,bean.getId() + ".jpg");
//        if(!file.getParentFile().exists())
//            file.getParentFile().mkdirs();
//        image.transferTo(file);
//        BufferedImage img = ImageUtil.change2jpg(file);
//        ImageIO.write(img, "jpg", file);
//    }
}
