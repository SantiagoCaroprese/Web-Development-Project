package com.javeriana.web.project.EmployeesTests.EmployeeTests;

import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeeFirstName;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFirstNameTests {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new EmployeeFirstName("John"));
    }

    @Test
    void should_throw_InvalidLength() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new EmployeeFirstName(""));
        assertEquals("Invalid number of characters", exception.getMessage());
    }
}
