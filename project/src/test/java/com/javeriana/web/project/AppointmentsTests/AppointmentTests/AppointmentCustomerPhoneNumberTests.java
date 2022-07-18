package com.javeriana.web.project.AppointmentsTests.AppointmentTests;

import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AppointmentCustomerPhoneNumber;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.InvalidPhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentCustomerPhoneNumberTests {

    @Test
    void should_not_throw_exceptions() {
        assertAll(() ->  new AppointmentCustomerPhoneNumber("12345678"));
    }

    @Test
    void should_throw_InvalidPhoneNumber() {
        Throwable exception = assertThrows(InvalidPhoneNumber.class, () -> new AppointmentCustomerPhoneNumber("12345678a"));
        assertEquals("Invalid phone number format", exception.getMessage());
    }

    @Test
    void should_throw_InvalidLength() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new AppointmentCustomerPhoneNumber("123"));
        assertEquals("Invalid phone number length", exception.getMessage());
    }

}
