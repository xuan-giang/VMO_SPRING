package com.example.springwithunittest.repository;

import com.example.springwithunittest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(Long id);
}
