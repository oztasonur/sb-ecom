package com.onuroztas.sbecom.service;

import com.onuroztas.sbecom.model.Category;
import com.onuroztas.sbecom.payload.CategoryDTO;
import com.onuroztas.sbecom.payload.CategoryResponse;


public interface CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
