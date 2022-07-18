package com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.PhoneNumber;

public class AppointmentCustomerPhoneNumber extends PhoneNumber {

    public AppointmentCustomerPhoneNumber(String value) {
        super(value);
    }

    public AppointmentCustomerPhoneNumber() {
    }
}
