package com.javeriana.web.project.Employees.Employee.Domain.Exceptions;

public class EmployeeAlreadyExist extends RuntimeException {
    public EmployeeAlreadyExist(String message){
        super(message);
    }
}
