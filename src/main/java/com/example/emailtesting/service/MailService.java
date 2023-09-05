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
    public static final String TEST_CONTENT="welcome to Arsenal";
    public static final String TEST_SUBJECT="Confirmation message";

    public void sendEmail(String toEmail, String subject, String content  ) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);

        mailMessage.setSubject(subject);

        mailMessage.setText(content);

        javaMailSender.send(mailMessage);


    }
}
