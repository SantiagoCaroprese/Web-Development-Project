package com.javeriana.web.project.Appointments.Appointment.Application.Update;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AppointmentProperty;
import java.util.List;

public class AppointmentModifier {
    private AppointmentRepository repository;

    public AppointmentModifier(AppointmentRepository repository){
        this.repository = repository;
    }

    public void execute(AppointmentProperty property){
        List<Appointment> actualAppointments = repository.findByProperty(property.getPropertyId()).get();
        for(Appointment a : actualAppointments){
            a.updateProperty(property);
        }
        this.repository.updateProperty(actualAppointments);
    }
}

