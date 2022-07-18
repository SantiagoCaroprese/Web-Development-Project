package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeeLastName;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.Address;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new Address("Doe"));
    }

    @Test
    void should_throw_InvalidLength_Empty() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new Address(""));
        assertEquals("Invalid number of characters", exception.getMessage());
    }

    @Test
    void should_throw_InvalidLength_ToManyCharacters() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new Address("abcdfghijklmnopqrstuvwxyz1234567891011121131415161718192021222324252627282930"));
        assertEquals("Invalid number of characters", exception.getMessage());
    }
}
