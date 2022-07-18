package com.javeriana.web.project.Appointments.Appointment.Application.Cancel;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.EmailSender;

import javax.mail.MessagingException;
import java.io.IOException;

public class CancellationNotifier {

    private EmailSender sender;

    public CancellationNotifier(EmailSender sender) {
        this.sender = sender;
    }

    public void execute(Appointment appointment) {
        try {
            sendCustomerEmail(appointment);
            if(appointment.getAssignedEmployee().isPresent()){
                sendEmployeeEmail(appointment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendCustomerEmail(Appointment appointment) throws IOException, MessagingException {
        String subject = "Appointment cancellation notification";
        String message = "<h1> Sorry, your appointment was cancelled. </h1>" +
                "<p> Your appointment at " + appointment.getAppointmentProperty().get("address")
                + " which was scheduled for " + appointment.getAppointmentDateTime().value().toString() +
                " was cancelled because our employees cannot join you. </p>" +
                "<p> We are really sorry, please feel free to book another appointment. </p>";
        sender.send(appointment.getAppointmentCustomerEmail().value(), subject, message);
    }

    private void sendEmployeeEmail(Appointment appointment) throws IOException, MessagingException {
        String subject = "Appointment cancellation notification";
        String message = "<h1> An appointment you were assigned to was cancelled. </h1>" +
                "<p> Your appointment at " + appointment.getAppointmentProperty().get("address")
                + " which was scheduled for " + appointment.getAppointmentDateTime().value().toString() +
                " was cancelled. </p>";
        sender.send((String) appointment.getAssignedEmployee().get().get("email"), subject, message);
    }

}
