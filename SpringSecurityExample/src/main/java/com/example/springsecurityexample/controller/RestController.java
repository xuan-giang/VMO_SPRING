package com.example.springsecurityexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @GetMapping("/test")
    public ResponseEntity<Object> get(){
        return new ResponseEntity<Object>("get", HttpStatus.OK);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable("id") Long id){
        return new ResponseEntity<Object>("get-detail",HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<Object> post(){
        return new ResponseEntity<Object>("post",HttpStatus.OK);
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
