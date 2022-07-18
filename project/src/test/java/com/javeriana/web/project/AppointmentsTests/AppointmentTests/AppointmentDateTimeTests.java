package com.javeriana.web.project.AppointmentsTests.AppointmentTests;

import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AppointmentDateTime;
import com.javeriana.web.project.Shared.Domain.PastDateException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentDateTimeTests {

    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new AppointmentDateTime(LocalDateTime.of(2021, 8, 21, 16, 0)));
    }

    @Test
    void should_throw_PastDateException() {
        Throwable exception = assertThrows(PastDateException.class, () -> new AppointmentDateTime(LocalDateTime.of(2020, 8, 21, 16, 0)));
        assertEquals("The date chosen has already passed", exception.getMessage());
    }

}
