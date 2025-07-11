package com.onuroztas.sbecom.service;

import com.onuroztas.sbecom.model.Category;
import com.onuroztas.sbecom.payload.CategoryDTO;
import com.onuroztas.sbecom.payload.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    CategoryResponse getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
