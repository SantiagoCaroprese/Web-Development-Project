package com.javeriana.web.project.Employees.Employee.Domain.Services;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;

import java.util.Optional;

public class EmployeeDomainFinder {
    private EmployeeRepository repository;

    public EmployeeDomainFinder(EmployeeRepository repository){
        this.repository = repository;
    }

    public Optional<Employee> execute (String employeeId){
        Optional<Employee> employee = repository.find(employeeId);

        if(employee.isEmpty()){
            throw new EmployeeNotExist("El empleado con el id: "+employeeId+" no existe");
        }

        return employee;
    }
}
