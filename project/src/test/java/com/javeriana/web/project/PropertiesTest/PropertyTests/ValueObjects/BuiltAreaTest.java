package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.BuiltArea;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuiltAreaTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new BuiltArea(1000));
    }

    @Test
    void should_throw_InvalidNumber_Negative() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new BuiltArea(-1));
        assertEquals("Invalid area number", exception.getMessage());
    }
    @Test
    void should_throw_InvalidNumber_Zero() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new BuiltArea(0));
        assertEquals("Invalid area number", exception.getMessage());
    }

    @Test
    void should_throw_InvalidNumber_21() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new BuiltArea(100000001));
        assertEquals("Invalid area number", exception.getMessage());
    }
}
