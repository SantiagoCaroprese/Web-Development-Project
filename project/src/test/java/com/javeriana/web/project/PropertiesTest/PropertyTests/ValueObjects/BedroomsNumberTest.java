package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.BedroomsNumber;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BedroomsNumberTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new BedroomsNumber(10));
    }

    @Test
    void should_throw_InvalidNumber_Negative() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new BedroomsNumber(-1));
        assertEquals("Invalid number of rooms", exception.getMessage());
    }
    @Test
    void should_throw_InvalidNumber_Zero() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new BedroomsNumber(0));
        assertEquals("Invalid number of rooms", exception.getMessage());
    }

    @Test
    void should_throw_InvalidNumber_21() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new BedroomsNumber(21));
        assertEquals("Invalid number of rooms", exception.getMessage());
    }
}
