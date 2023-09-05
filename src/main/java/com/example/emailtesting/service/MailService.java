package com.example.emailtesting.service;

import com.example.emailtesting.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MailService {
    private final JavaMailSender javaMailSender;


    public void sendEmail(Users users ) {
        String subject = "Confirmation message";
        String content = "welcome to Arsenal";

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(users.getEmail());

        mailMessage.setSubject(subject);

        mailMessage.setText(content);

        javaMailSender.send(mailMessage);


    }
}
