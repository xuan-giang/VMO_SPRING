package com.example.springsecurityexample.model;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestUser {

    @Test
    public void testPassword()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String beforePassword = "giang123";
        String afterPassword = bCryptPasswordEncoder.encode(beforePassword);

        System.out.println(bCryptPasswordEncoder.matches(beforePassword, afterPassword));


    }
}
