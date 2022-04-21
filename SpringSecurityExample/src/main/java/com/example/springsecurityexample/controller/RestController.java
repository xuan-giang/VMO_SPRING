package com.example.springsecurityexample.controller;

import com.example.springsecurityexample.model.Book;
import com.example.springsecurityexample.model.User;
import com.example.springsecurityexample.service.BookService;
import com.example.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/test")
    public List<User> get(){
        return userService.getAllUser();
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable("id") Long id){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/test")
    public ResponseEntity<?> post(@Valid @RequestParam("username") String username, @Valid @RequestParam("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userService.createUser(user);
        return new ResponseEntity<Object>("post",HttpStatus.OK);
    }

    @PostMapping("/test/book")
    public ResponseEntity<?> postNewBook(@RequestBody @Valid Book book)
    {
        return ResponseEntity.status(200).body(bookService.save(book));
    }

    @PutMapping("/test/{id}")
    public ResponseEntity<Object> put(){
        return new ResponseEntity<Object>("put",HttpStatus.OK);
    }

    @DeleteMapping("/test/{id}")
    public ResponseEntity<Object> delete(){
        return new ResponseEntity<Object>("delete",HttpStatus.OK);
    }


}
