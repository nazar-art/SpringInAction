package com.habuma.spitter.alerts;

import com.habuma.spitter.domain.Spittle;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("alertService")
public class AlertServiceImpl implements AlertService {
    private JavaMailSender mailSender;
    private String alertEmailAddress;

    public AlertServiceImpl(JavaMailSender mailSender,
                            String alertEmailAddress) {
        this.mailSender = mailSender;
        this.alertEmailAddress = alertEmailAddress;
    }

    public void sendSpittleAlert(final Spittle spittle) {
        SimpleMailMessage message = new SimpleMailMessage();
        String spitterName = spittle.getSpitter().getFullName();
        message.setFrom("noreply@spitter.com");
        message.setTo(alertEmailAddress);
        message.setSubject("New spittle from " + spitterName);
        message.setText(spitterName + " says: " + spittle.getText());
        mailSender.send(message);
    }
}
