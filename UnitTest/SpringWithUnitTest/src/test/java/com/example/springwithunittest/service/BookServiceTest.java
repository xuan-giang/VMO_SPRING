package com.example.springwithunittest.service;

import com.example.springwithunittest.entity.Book;
import com.example.springwithunittest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImpl bookService;

    @Test
    void testGetAll() // when get all -> should return list
    {
        // 1. Create mock data
        List<Book> mockBooks = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            mockBooks.add(new Book((long)i));
        }

        // 2. Define behavior of repository
        when(bookRepository.findAll()).thenReturn(mockBooks);

        // 3. Call service method
        List<Book> actualBooks = bookService.getAll();

        // 4. Assert the result
        assertThat(actualBooks.size()).isEqualTo(mockBooks.size());
        verify(bookRepository).findAll();

        System.out.println(mockBooks+"\n");
        System.out.println(actualBooks);
    }
}
