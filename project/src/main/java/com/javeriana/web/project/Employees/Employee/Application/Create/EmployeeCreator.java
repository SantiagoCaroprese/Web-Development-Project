package com.javeriana.web.project.Employees.Employee.Application.Create;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Services.EmployeeDomainFinder;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyAlreadyExist;

public class EmployeeCreator {
    private EmployeeRepository repository;
    private EmployeeDomainFinder finder;

    public EmployeeCreator(EmployeeRepository repository){
        this.repository = repository;
        this.finder = new EmployeeDomainFinder(repository);
    }


    public void execute(String employeeId,String employeeEmail,String employeePassword,String employeeFirstName,String employeeLastName,Boolean employeeIsAdministrator){
        this.validate(employeeId);
        Employee employee = new Employee(new EmployeeId(employeeId),new EmployeeEmail(employeeEmail), new EmployeePassword(employeePassword),new EmployeeFirstName(employeeFirstName),new EmployeeLastName(employeeLastName),new EmployeeIsAdministrator(employeeIsAdministrator));
        repository.save(employee);
    }

    private void validate(String employeeId){
        try{
            this.finder.execute(employeeId);
            throw new PropertyAlreadyExist("El empleado con el ID: "+employeeId+ " ya existe");
        }
        catch (EmployeeNotExist exception){

        }
    }
}
