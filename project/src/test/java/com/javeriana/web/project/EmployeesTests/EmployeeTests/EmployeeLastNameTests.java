package com.javeriana.web.project.EmployeesTests.EmployeeTests;

import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeeLastName;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeLastNameTests {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new EmployeeLastName("Doe"));
    }

    @Test
    void should_throw_InvalidLength() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new EmployeeLastName(""));
        assertEquals("Invalid number of characters", exception.getMessage());
    }
}
