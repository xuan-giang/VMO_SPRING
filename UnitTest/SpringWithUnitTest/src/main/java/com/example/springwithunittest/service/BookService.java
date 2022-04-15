package com.example.springwithunittest.service;

import com.example.springwithunittest.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book getOne(Long id);

    void saveBook(Book book);
}
