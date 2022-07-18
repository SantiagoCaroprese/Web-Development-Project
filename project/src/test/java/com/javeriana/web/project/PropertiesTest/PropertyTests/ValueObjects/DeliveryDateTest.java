package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.DeliveryDate;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryDateTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new DeliveryDate(LocalDate.now()));
    }

    @Test
    void should_throw_InvalidNumber() {
        LocalDate localDate= LocalDate.now().minusDays(1);
        Throwable exception = assertThrows(InvalidNumber.class, () -> new DeliveryDate(localDate));
        assertEquals("Invalid date", exception.getMessage());
    }
}
