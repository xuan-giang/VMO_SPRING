package com.example.springsecurityexample.service;

import com.example.springsecurityexample.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    Book getBookById(Long id);

    //void save(Book book);

    Book save(Book  book);

    void deleteBookById(Long id);
}
