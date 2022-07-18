package com.javeriana.web.project.EmployeesTests.EmployeeTests;

import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeePassword;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeePasswordTests {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new EmployeePassword("12345678"));
    }

    @Test
    void should_throw_InvalidLength() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new EmployeePassword("1234567"));
        assertEquals("Invalid number of characters", exception.getMessage());
    }
}
