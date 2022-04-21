package com.example.springsecurityexample.controller;

import com.example.springsecurityexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/home-page")
    public String homePage() {
        Authentication authen =  SecurityContextHolder.getContext().getAuthentication();
        return "home-page";
    }


    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

}
