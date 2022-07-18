package com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.CustomUUID;

public class AppointmentId extends CustomUUID {

    public AppointmentId() {
        super();
    }

    public AppointmentId(String value) {
        super(value);
    }
}
