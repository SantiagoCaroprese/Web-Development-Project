package com.javeriana.web.project.EmployeesTests.EmployeeTests;

import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeeEmail;
import com.javeriana.web.project.Shared.Domain.InvalidEmail;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeEmailTests {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new EmployeeEmail("test@example.com"));
    }

    @Test
    void should_throw_InvalidLength() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new EmployeeEmail("t@e"));
        assertEquals("Invalid number of characters", exception.getMessage());
    }

    @Test
    void should_throw_InvalidEmail() {
        Throwable exception = assertThrows(InvalidEmail.class, () -> new EmployeeEmail("test@"));
        assertEquals("Invalid email", exception.getMessage());
    }
}
