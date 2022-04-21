package com.example.springsecurityexample.repository;

import com.example.springsecurityexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(Long id);
}
