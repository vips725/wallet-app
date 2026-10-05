package com.vipul.Vipul.pos.system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${BREVO_FROM_EMAIL}")
    private String fromEmail;

    public void sendEmail(String to, String subject, String body) {

        try {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(fromEmail);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);

            System.out.println("Email sent successfully to: " + to);

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Email sending failed: " + e.getMessage(),
                    e
            );
        }
    }
}