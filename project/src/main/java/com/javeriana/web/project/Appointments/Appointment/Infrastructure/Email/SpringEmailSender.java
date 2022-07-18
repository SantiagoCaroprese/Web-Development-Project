package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Email;

import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.EmailSender;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class SpringEmailSender implements EmailSender {

    private final String HOST = "smtp.mailtrap.io";
    private final String USERNAME = "2d8c7309613d79";
    private final String PASSWORD = "73508b4a642e36";
    private final String SENDER = "noreply@realestate.com";

    @Override
    public void send(String mailTo, String subject, String message) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(SENDER, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
        msg.setSubject(subject);
        msg.setContent(message, "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }

}
