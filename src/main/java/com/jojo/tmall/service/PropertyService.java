package com.jojo.tmall.service;

import com.jojo.tmall.dao.PropertyDAO;
import com.jojo.tmall.pojo.Category;
import com.jojo.tmall.pojo.Property;
import com.jojo.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    CategoryService categoryService;

    public void add(Property property){
        propertyDAO.save(property);
    }

    public void delete(int id){
        propertyDAO.deleteById(id);
    }

    public void update(Property property){
        propertyDAO.save(property);
    }

    public Property get(int id){
        return propertyDAO.getOne(id);
    }

    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Property> pageFromJPA = propertyDAO.findByCategory(category, pageable);
        return new Page4Navigator<Property>(pageFromJPA, navigatePages);
    }

    public List<Property> getAll(int cid) {
        Category category = categoryService.get(cid);
        List<Property> propertyList = propertyDAO.findAllByCategory_Id(cid);
        return propertyList;
    }
}
