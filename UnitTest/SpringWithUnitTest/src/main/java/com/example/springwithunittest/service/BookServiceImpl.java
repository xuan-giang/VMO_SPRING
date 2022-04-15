package com.example.springwithunittest.service;

import com.example.springwithunittest.entity.Book;
import com.example.springwithunittest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getOne(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }


}
