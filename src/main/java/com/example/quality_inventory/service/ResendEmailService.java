package com.example.quality_inventory.service;

import com.resend.Resend;
import com.resend.services.emails.model.SendEmailRequest;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class ResendEmailService {
    @Value("${resend.api-key}")
    private String apiKey;

    public void sendMail(String to, String subject, String body) {

        Resend resend = new Resend(apiKey);

        SendEmailRequest request = SendEmailRequest.builder()
                .from("Manufacturing <kavin.v@mitrahsoft.in>")
                .to(to)
                .subject(subject)
                .text(body)
                .build();

        resend.emails().send(request);

    }
}
