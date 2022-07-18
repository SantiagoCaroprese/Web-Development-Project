package com.javeriana.web.project.Appointments.Appointment.Domain.Exceptions;

public class AppointmentNotExist extends RuntimeException{
    public AppointmentNotExist(String message){super(message);}
}
