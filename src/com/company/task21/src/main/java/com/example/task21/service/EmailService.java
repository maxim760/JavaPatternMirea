package com.example.task21.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    @Value("${mail.to}")
    private String mailTo;

    @Value("${mail.from}")
    private String mailFrom;

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(String title, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailTo);
        msg.setFrom(mailFrom);
        System.out.println(mailTo);
        msg.setSubject(title);
        msg.setText(text);
        System.out.println(title + " " + text);
        javaMailSender.send(msg);
        log.info("Сообщение на email отправлено: " + title);

    }
}