package com.javeriana.web.project.Appointments.Appointment.Application.Unassigned;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UnassignedAppointmentsResponse {

    private List<Appointment> unassignedAppointments;

    public UnassignedAppointmentsResponse(List<Appointment> unassignedAppointments) {
        this.unassignedAppointments = unassignedAppointments;
    }

    public List<HashMap> response() {
        List<HashMap> response = unassignedAppointments.stream().map(a -> a.data()).collect(Collectors.toList());
        return response;
    }

}
