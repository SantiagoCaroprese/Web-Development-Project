package com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.Email;

public class AppointmentCustomerEmail extends Email {

    public AppointmentCustomerEmail(String value) {
        super(value);
    }

    public AppointmentCustomerEmail() {
        super();
    }
}
