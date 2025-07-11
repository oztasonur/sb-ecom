package com.onuroztas.sbecom.service;

import com.onuroztas.sbecom.exceptions.APIException;
import com.onuroztas.sbecom.exceptions.ResourceNotFoundException;
import com.onuroztas.sbecom.model.Category;
import com.onuroztas.sbecom.payload.CategoryDTO;
import com.onuroztas.sbecom.payload.CategoryResponse;
import com.onuroztas.sbecom.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty())
            throw new APIException("No category created till now.");


        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null)
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists.");
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " deleted successfully.";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {


        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() ->new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }


}
