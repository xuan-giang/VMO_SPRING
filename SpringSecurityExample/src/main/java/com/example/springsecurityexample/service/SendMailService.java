package com.example.springsecurityexample.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SendMailService {
    String sendMailWithText(String sub, String content, String to);



}
