package com.example.task21.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
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
    private MailSender javaMailSender;


    public void sendEmail(String title, String text) {
        try {
            System.out.println("start send");
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(mailTo);
            msg.setFrom(mailFrom);
            System.out.println(mailTo + "mailto" + javaMailSender.toString());
            msg.setSubject(title);
            msg.setText(text);
            System.out.println(title + " " + text + "title and text");
            javaMailSender.send(msg);
            log.info("Сообщение на email отправлено: " + title);
        } catch(Exception e) {
            System.out.println("Ошибка:" + e.getMessage());
        }

    }
}