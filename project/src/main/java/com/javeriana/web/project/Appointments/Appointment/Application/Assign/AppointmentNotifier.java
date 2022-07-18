package com.javeriana.web.project.Appointments.Appointment.Application.Assign;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.EmailSender;

import javax.mail.MessagingException;
import java.io.IOException;

public class AppointmentNotifier {

    private EmailSender sender;

    public AppointmentNotifier(EmailSender sender) {
        this.sender = sender;
    }

    public void execute(Appointment appointment) {
        try {
            sendCustomerEmail(appointment);
            sendEmployeeEmail(appointment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendCustomerEmail(Appointment appointment) throws IOException, MessagingException {
        String subject = "Appointment confirmation notification";
        String message = "<h1> Your appointment has been confirmed. </h1>" +
                "<p> Your appointment at " + appointment.getAppointmentProperty().get("address")
                + " which is scheduled for " + appointment.getAppointmentDateTime().value().toString() +
                " has been assigned to our employee: </p>" +
                "<h4> " + appointment.getAssignedEmployee().get().get("firstName")
                + " " + appointment.getAssignedEmployee().get().get("lastName") + " </h4>" +
                "<ul>" +
                    "<li> Email: " + appointment.getAssignedEmployee().get().get("email") + " </li>" +
                "</ul>" +
                "<p> In case you cannot attend the appointment,<a href=\"http://http://localhost:8080/appointments/cancelation/"
                + appointment.getAppointmentId() + "\"> click here </a>. </p>";
        sender.send(appointment.getAppointmentCustomerEmail().value(), subject, message);
    }

    private void sendEmployeeEmail(Appointment appointment) throws IOException, MessagingException {
        String subject = "Appointment confirmation notification";
        String message = "<h1> You have been assigned to an appointment. </h1>" +
                "<p> Yo have been assigned to an appointment at " + appointment.getAppointmentProperty().get("address")
                + ", scheduled for " + appointment.getAppointmentDateTime().value().toString() + "</p>" +
                "<h2> Customer Information </h2>" +
                "<ul>" +
                "<li> Name: " + appointment.getAppointmentCustomerFirstName().value()
                + " " + appointment.getAppointmentCustomerLastName().value()  + " </li>" +
                "<li> Email: " + appointment.getAppointmentCustomerEmail().value() + " </li>" +
                "<li> Phone number: " + appointment.getAppointmentCustomerPhoneNumber().value() + " </li>" +
                "</ul>";
        sender.send((String) appointment.getAssignedEmployee().get().get("email"), subject, message);
    }

}
