package com.javeriana.web.project.EmployeesTests.EmployeeLoginTests;

import com.javeriana.web.project.Employees.Employee.Application.Login.EmployeeLogin;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.WrongCredentials;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;
import com.javeriana.web.project.Employees.Employee.Infrastructure.Security.JWTTokenGenerator;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class EmployeeLoginTests {
    @Test
    void should_not_throw_exceptions() {
        EmployeeRepository repository = mock(EmployeeRepository.class);
        Employee employee = new Employee(
                new EmployeeId("c6575120-a952-4bff-b999-a7e1827f8bb7"),
                new EmployeeEmail("test@example.com"),
                new EmployeePassword("1234"),
                new EmployeeFirstName("John"),
                new EmployeeLastName("Doe"),
                new EmployeeIsAdministrator(false));
        Mockito.when(repository.authenticate("test@example.com", "1234")).thenReturn(employee);
        EmployeeLogin useCase = new EmployeeLogin(new JWTTokenGenerator(), repository);
        assertAll(() -> useCase.execute("test@example.com", "1234"));
    }

    @Test
    void should_throw_WrongCredentials() {
        EmployeeRepository repository = mock(EmployeeRepository.class);
        Mockito.when(repository.authenticate("test@example.com", "1234")).thenThrow(new WrongCredentials("Wrong username or password"));
        EmployeeLogin useCase = new EmployeeLogin(new JWTTokenGenerator(), repository);
        Throwable exception = assertThrows(WrongCredentials.class, () -> useCase.execute("test@example.com", "1234"));
        assertEquals("Wrong username or password", exception.getMessage());
    }
}
