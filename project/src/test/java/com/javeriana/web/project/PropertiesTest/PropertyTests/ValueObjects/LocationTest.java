package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.Location;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.PrivateArea;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new Location(Long.valueOf(0),Long.valueOf(0)));
    }

    @Test
    void should_throw_InvalidNumber_ToSmallLatitude() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new Location(Long.valueOf(-91),Long.valueOf(-180)));
        assertEquals("Invalid latitude number", exception.getMessage());
    }

    @Test
    void should_throw_InvalidNumber_ToBigLatitude() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new Location(Long.valueOf(91),Long.valueOf(180)));
        assertEquals("Invalid latitude number", exception.getMessage());
    }

    @Test
    void should_throw_InvalidNumber_ToSmallLongitude() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new Location(Long.valueOf(-90),Long.valueOf(-181)));
        assertEquals("Invalid longitude number", exception.getMessage());
    }

    @Test
    void should_throw_InvalidNumber_ToBigLongitude() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new Location(Long.valueOf(90),Long.valueOf(181)));
        assertEquals("Invalid longitude number", exception.getMessage());
    }
}
