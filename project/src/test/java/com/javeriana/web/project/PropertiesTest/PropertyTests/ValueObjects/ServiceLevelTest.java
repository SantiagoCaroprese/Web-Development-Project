package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.ServiceLevel;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceLevelTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new ServiceLevel(6));
    }

    @Test
    void should_throw_InvalidNumber_Negative() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new ServiceLevel(-1));
        assertEquals("Invalid service level", exception.getMessage());
    }
    @Test
    void should_throw_InvalidNumber_Zero() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new ServiceLevel(0));
        assertEquals("Invalid service level", exception.getMessage());
    }

    @Test
    void should_throw_InvalidNumber_21() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new ServiceLevel(7));
        assertEquals("Invalid service level", exception.getMessage());
    }
}
