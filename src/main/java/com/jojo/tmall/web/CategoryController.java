package com.jojo.tmall.web;

import com.jojo.tmall.pojo.Category;
import com.jojo.tmall.service.CategoryService;
import com.jojo.tmall.util.ImageUtil;
import com.jojo.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        Page4Navigator<Category> page = categoryService.list(start, size, 5);
        return page;
    }

    /**
     * 上传的图片存放在img/category文件夹，并不存在数据库中
     * 若把图片以二进制的方式存在数据库中会加重数据库负担，拖慢访问速度，尤其是在大并发访问的情况下
     * @param bean
     * @param image
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    private void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        categoryService.delete(id);
        File  imageFolder= new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id + ".jpg");
        file.delete();
        return null;
    }

    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id) throws Exception {
        Category bean = categoryService.get(id);
        return bean;
    }

    @PutMapping("/categories/{id}")
    public Object update(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);
        if(image != null) {
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }
}
