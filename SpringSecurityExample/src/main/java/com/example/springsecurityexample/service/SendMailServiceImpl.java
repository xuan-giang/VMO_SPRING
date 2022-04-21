package com.example.springsecurityexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService{

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public String sendMailWithText(String sub, String content, String to) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setSubject(sub);
            simpleMailMessage.setText(content);
            simpleMailMessage.setTo(to);

            javaMailSender.send(simpleMailMessage);
        }catch (Exception e) {
            return "Send failed";
        }

        return "Send successfully";
    }
}
