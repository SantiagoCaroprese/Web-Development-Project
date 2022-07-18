package com.javeriana.web.project.Employees.Employee.Domain.Exceptions;

public class WrongCredentials extends RuntimeException{

    public WrongCredentials(String message) {
        super(message);
    }
}
