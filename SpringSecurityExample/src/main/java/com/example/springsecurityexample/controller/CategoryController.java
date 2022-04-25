package com.example.springsecurityexample.controller;

import com.example.springsecurityexample.dto.CategoryDto;
import com.example.springsecurityexample.service.CategoryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategories()
    {
        return ResponseEntity.status(200).body(categoryService.findAll());
    }

    @PostMapping("/category")
    public ResponseEntity<?> createNewCategory(@RequestBody CategoryDto categoryDto)
    {
        return ResponseEntity.status(200).body(categoryService.create(categoryDto));
    }
}
