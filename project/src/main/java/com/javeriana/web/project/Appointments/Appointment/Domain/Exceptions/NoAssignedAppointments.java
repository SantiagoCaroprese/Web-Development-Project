package com.javeriana.web.project.Appointments.Appointment.Domain.Exceptions;

public class NoAssignedAppointments extends RuntimeException{
    public NoAssignedAppointments(String message) {
        super(message);
    }
}
