package com.javeriana.web.project.Appointments.Appointment.Application.Book;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.*;
import com.javeriana.web.project.Properties.Property.Application.Find.PropertyFinder;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyNotExist;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.PropertyDomainFinder;
import com.javeriana.web.project.Shared.Domain.CustomUUID;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class AppointmentBooker {

    private AppointmentRepository repository;
    private PropertyFinder finder;

    public AppointmentBooker(AppointmentRepository repository, PropertyFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String appointmentId,
                        String propertyId,
                        int year,
                        int month,
                        int day,
                        int hour,
                        int minute,
                        String customerFirstName,
                        String customerLastName,
                        String customerEmail,
                        String customerPhoneNumber) {
        Property property = finder.execute(propertyId);
        repository.save(new Appointment(
                new AppointmentId(appointmentId),
                new AppointmentProperty(
                        propertyId,
                        property.getAddress().value(),
                        property.getPropertyType().value(),
                        property.getCity().value(),
                        (long) property.getLatitude().value(),
                        (long) property.getLongitude().value()),
                new AppointmentDateTime(LocalDateTime.of(year, month, day, hour, minute)),
                new AppointmentCustomerFirstName(customerFirstName),
                new AppointmentCustomerLastName(customerLastName),
                new AppointmentCustomerEmail(customerEmail),
                new AppointmentCustomerPhoneNumber(customerPhoneNumber)));
    }

}
