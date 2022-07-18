package com.javeriana.web.project.Appointments.Appointment.Application.FindAssigned;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindAssignedAppointmetsResponse {

    private List<Appointment> appointments;

    public FindAssignedAppointmetsResponse(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<HashMap> response(){
        List<HashMap> response = appointments.stream().map(a -> a.data()).collect(Collectors.toList());
        return  response;
    }
}
