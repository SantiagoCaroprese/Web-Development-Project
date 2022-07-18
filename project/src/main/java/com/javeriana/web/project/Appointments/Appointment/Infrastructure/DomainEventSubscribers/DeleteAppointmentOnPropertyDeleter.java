package com.javeriana.web.project.Appointments.Appointment.Infrastructure.DomainEventSubscribers;

import com.javeriana.web.project.Appointments.Appointment.Application.Book.AppointmentBooker;
import com.javeriana.web.project.Appointments.Appointment.Application.Cancel.CancelAppointment;
import com.javeriana.web.project.Appointments.Appointment.Application.Delete.AppointmentsDeleter;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyDeleterDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({PropertyDeleterDomainEvent.class})
public final class DeleteAppointmentOnPropertyDeleter {

    //private AppointmentsDeleter appointmentDeleter;
    private AppointmentsDeleter appointmentsDeleter;

    public DeleteAppointmentOnPropertyDeleter(AppointmentsDeleter appointmentsDeleter){
        this.appointmentsDeleter = appointmentsDeleter;
    }

    @EventListener
    public void on(PropertyDeleterDomainEvent event){
        appointmentsDeleter.execute(event.aggregateId());
    }

}
