package com.javeriana.web.project.Appointments.Appointment.Infrastructure.DomainEventSubscribers;

import com.javeriana.web.project.Appointments.Appointment.Application.Book.AppointmentBooker;
import com.javeriana.web.project.Appointments.Appointment.Application.Update.AppointmentModifier;
import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AppointmentProperty;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyModifierDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({PropertyModifierDomainEvent.class})
public final class UpdateAppointmentOnPropertyModifier {

    private AppointmentModifier appointmentModifier;
    public UpdateAppointmentOnPropertyModifier(AppointmentModifier appointmentModifier){
        this.appointmentModifier = appointmentModifier;
    }
    @EventListener
    public void on(PropertyModifierDomainEvent event){
        this.appointmentModifier.execute(new AppointmentProperty(event.aggregateId(), event.getAddress(),
                event.getPropertyType(), event.getCity(), (long)event.getLatitude(),(long)event.getLongitude()));
    }
}
