package com.javeriana.web.project.Employees.Employee.Application.Update;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Services.EmployeeDomainFinder;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;

import java.util.Optional;

public class EmployeeModifier {
    private EmployeeRepository repository;
    private EmployeeDomainFinder finder;

    public EmployeeModifier(EmployeeRepository repository){
        this.repository = repository;
        this.finder = new EmployeeDomainFinder(repository);
    }

    public void execute (String employeeId,String employeeEmail,String employeePassword,String employeeFirstName,String employeeLastName,Boolean employeeIsAdministrator){
        Optional<Employee> actualEmployee = finder.execute(employeeId);
        Employee oldEmployee = actualEmployee.get();
        oldEmployee.updateEmployee(new EmployeeEmail(employeeEmail),new EmployeePassword(employeePassword), new EmployeeFirstName(employeeFirstName),new EmployeeLastName(employeeLastName), new EmployeeIsAdministrator(employeeIsAdministrator));
        repository.update(employeeId, oldEmployee);
    }
}
