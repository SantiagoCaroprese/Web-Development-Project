package com.javeriana.web.project.Employees.Employee.Domain.Ports;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Shared.Domain.Token;

public interface TokenGenerator {
    public Token getToken(Employee employee);
}
