package com.javeriana.web.project.Appointments.Appointment.Application.Unassigned;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Infrastructure.Hibernate.HibernateAppointmentRepository;

import java.util.List;

public class UnassignedAppointmentsGetter {

    private AppointmentRepository repository;

    public UnassignedAppointmentsGetter(HibernateAppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> execute() {
        return repository.getUnassignedAppointments();
    }

}
