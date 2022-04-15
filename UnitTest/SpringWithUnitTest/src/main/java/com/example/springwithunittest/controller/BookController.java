package com.example.springwithunittest.controller;

import com.example.springwithunittest.entity.Book;
import com.example.springwithunittest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    public List<Book> getAllBooks()
    {
        return bookService.getAll();
    }

    @PostMapping("/api/books")
    public String createNewBook(@RequestBody Book book)
    {
        bookService.saveBook(book);
        return "Created book successfully!";
    }
}
