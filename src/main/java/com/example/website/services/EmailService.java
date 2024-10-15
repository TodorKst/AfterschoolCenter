package com.example.website.services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
private static final String EMAIL_ADDRESS = "email@placeholder.com";

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String name, String email, String subject, String messageContent) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            String text = messageContent + "\n\n" + "Изпратено от: " + name + "\n" + "Имейл на клиента: " + email;
            helper.setTo(EMAIL_ADDRESS);
            helper.setSubject(subject);
            helper.setText(text);
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
