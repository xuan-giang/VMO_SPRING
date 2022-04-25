package com.example.springsecurityexample.service.Impl;


import com.example.springsecurityexample.model.Book;
import com.example.springsecurityexample.repository.BookRepository;
import com.example.springsecurityexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findBookById(id);
    }

//    @Override
//    public void save(Book book) {
//        bookRepository.save(book);
//    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
