package com.javeriana.web.project.Appointments.Appointment.Application.Cancel;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.Services.AppointmentDomainFinder;

import java.util.Optional;


public class CancelAppointment {
    private AppointmentRepository repository;
    private AppointmentDomainFinder finder;
    private CancellationNotifier notifier;

    public CancelAppointment(AppointmentRepository repository, CancellationNotifier notifier) {
        this.repository = repository;
        this.finder = new AppointmentDomainFinder(repository);
        this.notifier = notifier;
    }

    public void execute(String appointmentId){
        Optional<Appointment> actualAppointment = finder.execute(appointmentId);
        Appointment appointment = actualAppointment.get();
        notifier.execute(appointment);
        appointment.deleteAppointment(appointment);
        repository.delete(appointment);
    }
}
