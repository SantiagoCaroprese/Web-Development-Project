package com.javeriana.web.project.Appointments.Appointment.Application.DeleteExpiredAppointments;

import com.javeriana.web.project.Appointments.Appointment.Application.Cancel.CancelAppointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;

import java.util.List;

public class ExpiredAppointmentsDeleter {

    private AppointmentRepository repository;
    private CancelAppointment cancelAppointment;

    public ExpiredAppointmentsDeleter(AppointmentRepository repository, CancelAppointment cancelAppointment) {
        this.repository = repository;
        this.cancelAppointment = cancelAppointment;
    }

    public void execute(){
        List<Appointment> appointments=repository.getExpiredAppointments();
        for (Appointment ap: appointments) {
            cancelAppointment.execute(ap.getAppointmentId().value());
        }
    }
}
