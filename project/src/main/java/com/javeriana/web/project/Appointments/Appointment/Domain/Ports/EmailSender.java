package com.javeriana.web.project.Appointments.Appointment.Domain.Ports;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

public interface EmailSender {

    public void send(String mailTo, String subject, String message) throws MessagingException, IOException;

}
