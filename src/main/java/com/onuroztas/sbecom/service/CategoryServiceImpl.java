package com.onuroztas.sbecom.service;

import com.onuroztas.sbecom.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void CreateCategory(Category category) {
        categories.add(category);
    }
}
