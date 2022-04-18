package com.example.springsecurityexample.controller;

import com.example.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable("id") Long id){
        return ResponseEntity.status(200).body(userService.getAllUser());
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
