package com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class AppointmentCustomerLastName extends StringValueObject {

    public AppointmentCustomerLastName(String value) {
        super(value);
        this.validate(value);
    }

    public AppointmentCustomerLastName() {
    }

    private void validate(String value) {
        this.lengthRule(value);
    }

    private void lengthRule(String value) {
        if(value.length() < 1 || value.length() > 200) {
            throw new InvalidLength("Invalid number of characters");
        }
    }
}
