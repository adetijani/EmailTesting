package com.example.emailtesting.controller;

import com.example.emailtesting.model.Users;
import com.example.emailtesting.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MailController {
    private final MailService mail;

    @PostMapping("send")
    public ResponseEntity<String> sendEmail(@RequestBody Users users) {
        try {
            mail.sendEmail(users);
            return ResponseEntity.ok("Email sent");
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }
}
