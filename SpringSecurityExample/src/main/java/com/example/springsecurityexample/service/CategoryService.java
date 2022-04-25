package com.example.springsecurityexample.service;

import com.example.springsecurityexample.dto.CategoryDto;
import com.example.springsecurityexample.model.Category;

import java.util.List;

public interface CategoryService {

    public CategoryDto getCategory(String name);

    List<Category> findAll();

    Category findById(Long categoryId);

    Category create(CategoryDto categoryDTO);

    Category update(CategoryDto categoryUpdateDTO, Category currentCategory);

    void deleteById(Long categoryId);

}
