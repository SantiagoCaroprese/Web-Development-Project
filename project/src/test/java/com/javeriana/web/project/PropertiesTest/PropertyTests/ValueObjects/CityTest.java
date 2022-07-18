package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.City;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new City("Doe"));
    }

    @Test
    void should_throw_InvalidLength_Empty() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new City(""));
        assertEquals("Invalid number of characters", exception.getMessage());
    }

    @Test
    void should_throw_InvalidLength_ToManyCharacters() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new City("abcdfghijklmnopqrstuvwxyz123456789101112113141516171819202122232425262728293031323334353637383940"));
        assertEquals("Invalid number of characters", exception.getMessage());
    }
}
