package com.javeriana.web.project.Appointments.Appointment.Domain;

import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.*;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Shared.Domain.CustomUUID;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class Appointment {
    private AppointmentId appointmentId;
    private AppointmentProperty appointmentProperty;
    private AppointmentDateTime appointmentDateTime;
    private Optional<AssignedEmployee> assignedEmployee;
    private AppointmentCustomerFirstName appointmentCustomerFirstName;
    private AppointmentCustomerLastName appointmentCustomerLastName;
    private AppointmentCustomerEmail appointmentCustomerEmail;
    private AppointmentCustomerPhoneNumber appointmentCustomerPhoneNumber;

    public Appointment(AppointmentId appointmentId,
                       AppointmentProperty appointmentProperty,
                       AppointmentDateTime appointmentDateTime,
                       AppointmentCustomerFirstName appointmentCustomerFirstName,
                       AppointmentCustomerLastName appointmentCustomerLastName,
                       AppointmentCustomerEmail appointmentCustomerEmail,
                       AppointmentCustomerPhoneNumber appointmentCustomerPhoneNumber) {
        this.appointmentId = appointmentId;
        this.appointmentProperty = appointmentProperty;
        this.appointmentDateTime = appointmentDateTime;
        this.assignedEmployee = Optional.ofNullable(null);
        this.appointmentCustomerFirstName = appointmentCustomerFirstName;
        this.appointmentCustomerLastName = appointmentCustomerLastName;
        this.appointmentCustomerEmail = appointmentCustomerEmail;
        this.appointmentCustomerPhoneNumber = appointmentCustomerPhoneNumber;
    }

    public Appointment() {
    }



    public HashMap<String, String> data() {
        HashMap<String,String> data = new HashMap<String,String>(){{
            put("id", appointmentId.value());
            put("propertyId", appointmentProperty.getPropertyId());
            put("propertyType", appointmentProperty.getPropertyType());
            put("propertyCity", appointmentProperty.getCity());
            put("propertyAddress", appointmentProperty.getAddress());
            put("propertyLatitude", "" + appointmentProperty.getLatitude());
            put("propertyLongitude", "" + appointmentProperty.getLongitude());
            put("dateTime", appointmentDateTime.value().toString());
            put("day", "" + appointmentDateTime.value().getDayOfMonth());
            put("month", "" + appointmentDateTime.value().getMonthValue());
            put("year", "" + appointmentDateTime.value().getYear());
            put("hour", "" + appointmentDateTime.value().getHour());
            put("minute", "" + appointmentDateTime.value().getMinute());
            put("customerFirstName", appointmentCustomerFirstName.value());
            put("customerLastName", appointmentCustomerLastName.value());
            put("customerEmail", appointmentCustomerEmail.value());
            put("customerPhoneNumber", appointmentCustomerPhoneNumber.value());
        }};
        return data;
    }

    public HashMap<String, Object> getAppointmentProperty() {
        return appointmentProperty.data();
    }

    public Optional<HashMap<String, Object>> getAssignedEmployee() {
        HashMap<String, Object> response = (assignedEmployee.isPresent()) ? assignedEmployee.get().data() : null;
        return Optional.ofNullable(response);
    }

    public void setAssignedEmployee(AssignedEmployee assignedEmployee) {
        this.assignedEmployee = Optional.ofNullable(assignedEmployee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId) && Objects.equals(appointmentProperty, that.appointmentProperty) && Objects.equals(appointmentDateTime, that.appointmentDateTime) && Objects.equals(assignedEmployee, that.assignedEmployee) && Objects.equals(appointmentCustomerFirstName, that.appointmentCustomerFirstName) && Objects.equals(appointmentCustomerLastName, that.appointmentCustomerLastName) && Objects.equals(appointmentCustomerEmail, that.appointmentCustomerEmail) && Objects.equals(appointmentCustomerPhoneNumber, that.appointmentCustomerPhoneNumber);
    }

    public void assignEmployee(String employeeId, String email, String firstName, String lastName){
        this.assignedEmployee = Optional.ofNullable(new AssignedEmployee(employeeId,email,firstName,lastName));
    }

    public void deleteAppointment(Appointment appointment) {
    }

    public void updateProperty(AppointmentProperty property){
        this.appointmentProperty = property;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }

    public AppointmentDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public AppointmentCustomerFirstName getAppointmentCustomerFirstName() {
        return appointmentCustomerFirstName;
    }

    public AppointmentCustomerLastName getAppointmentCustomerLastName() {
        return appointmentCustomerLastName;
    }

    public AppointmentCustomerEmail getAppointmentCustomerEmail() {
        return appointmentCustomerEmail;
    }

    public AppointmentCustomerPhoneNumber getAppointmentCustomerPhoneNumber() {
        return appointmentCustomerPhoneNumber;
    }
}
