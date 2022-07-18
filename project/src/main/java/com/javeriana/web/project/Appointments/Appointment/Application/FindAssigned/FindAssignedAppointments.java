package com.javeriana.web.project.Appointments.Appointment.Application.FindAssigned;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;

import java.util.List;

public class FindAssignedAppointments {

    private AppointmentRepository repository;

    public FindAssignedAppointments(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> execute(String employeeId){
        return repository.findAssignedAppointmets(employeeId).get();
    }

}
