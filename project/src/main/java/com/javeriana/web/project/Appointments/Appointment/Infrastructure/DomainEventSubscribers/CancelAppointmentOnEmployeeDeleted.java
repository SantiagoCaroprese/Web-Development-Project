package com.javeriana.web.project.Appointments.Appointment.Infrastructure.DomainEventSubscribers;

import com.javeriana.web.project.Appointments.Appointment.Application.Cancel.CancelAppointment;
import com.javeriana.web.project.Appointments.Appointment.Application.FindAssigned.FindAssignedAppointments;
import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Employees.EmployeeDeletedDomainEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@DomainEventSubscriber({EmployeeDeletedDomainEvent.class})
public class CancelAppointmentOnEmployeeDeleted {

    private CancelAppointment cancelAppointment;
    private FindAssignedAppointments findAssignedAppointments;

    public CancelAppointmentOnEmployeeDeleted(CancelAppointment cancelAppointment, FindAssignedAppointments findAssignedAppointments) {
        this.cancelAppointment = cancelAppointment;
        this.findAssignedAppointments = findAssignedAppointments;
    }

    @EventListener
    public void on(EmployeeDeletedDomainEvent event) {
        List<Appointment> employeeAppointments = findAssignedAppointments.execute(event.aggregateId());
        for(Appointment appointment : employeeAppointments) {
            this.cancelAppointment.execute(appointment.getAppointmentId().value());
        }
    }

}
