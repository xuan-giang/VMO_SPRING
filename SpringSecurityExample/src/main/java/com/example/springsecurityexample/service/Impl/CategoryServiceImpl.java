package com.example.springsecurityexample.service.Impl;

import com.example.springsecurityexample.dto.CategoryDto;
import com.example.springsecurityexample.model.Category;
import com.example.springsecurityexample.repository.CategoryRepository;
import com.example.springsecurityexample.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private final ModelMapper mapper;

    public CategoryServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CategoryDto getCategory(String name) {
        Category category = categoryRepository.findCategoryByName(name);

        // Map thành DTO
        CategoryDto categoryDto = mapper.map(category, CategoryDto.class);

        return categoryDto;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long categoryId) {
        return categoryRepository.getById(categoryId);
    }

    @Override
    public Category create(CategoryDto categoryDTO) {
        Category category = mapper.map(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }

    @Override
    public Category update(CategoryDto categoryUpdateDTO, Category currentCategory) {
        Category category = mapper.map(categoryUpdateDTO, Category.class);
        mapper.map(category, currentCategory);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
