package com.example.springsecurityexample.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Secured("USER")
    @GetMapping("/home-page")
    public String homePage() {
        Authentication authen =  SecurityContextHolder.getContext().getAuthentication();
        return "home-page";
    }

    @Secured("ADMIN")
    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

}
