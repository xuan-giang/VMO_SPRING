package com.example.exceptionhandlerexample.controller;


import com.example.exceptionhandlerexample.dto.UserDTO;
import com.example.exceptionhandlerexample.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<?> getUser(@RequestBody UserDTO userDTO) {

        if (userDTO.getUsername().equals("")) {
            throw new NotFoundException("Username rỗng");
        }
        return ResponseEntity.status(200).body(userDTO);
    }

}
