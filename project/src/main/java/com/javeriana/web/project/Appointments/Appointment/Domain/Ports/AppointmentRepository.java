package com.javeriana.web.project.Appointments.Appointment.Domain.Ports;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AppointmentId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {

    void save(Appointment appointment);
    Optional<Appointment> find(String appointmentId);
    Appointment assignEmployee(String appointmentId, Appointment appointment);
    Optional<List<Appointment>> findAssignedAppointmets(String employeeId);
    void updateProperty(List<Appointment> appointments);
    void deleteForProperty(String propertyId);
    List<Appointment> getUnassignedAppointments();
    Optional<List<Appointment>> all();
    void delete(Appointment appointment);
    List<Appointment> getExpiredAppointments();
    Optional<List<Appointment>> findByProperty(String propertyId);
}
