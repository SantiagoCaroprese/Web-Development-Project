package com.javeriana.web.project.Employees.Employee.Domain.Exceptions;

public class EmployeeNotExist extends RuntimeException{
    public EmployeeNotExist(String message){
        super(message);
    }
}
