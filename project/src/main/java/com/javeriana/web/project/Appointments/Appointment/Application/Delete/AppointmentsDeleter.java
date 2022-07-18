package com.javeriana.web.project.Appointments.Appointment.Application.Delete;

import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;

public class AppointmentsDeleter {
    private AppointmentRepository repository;

    public AppointmentsDeleter(AppointmentRepository repository){
        this.repository = repository;
    }

    public void execute(String propertyId){
        this.repository.deleteForProperty(propertyId);
    }
}
