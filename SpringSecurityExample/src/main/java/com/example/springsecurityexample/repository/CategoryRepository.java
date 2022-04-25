package com.example.springsecurityexample.repository;

import com.example.springsecurityexample.model.Book;
import com.example.springsecurityexample.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByName(String name);
}
