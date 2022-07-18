package com.javeriana.web.project.Employees.Employee.Application.GetAll;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeesObtainer {
    private EmployeeRepository repository;

    public EmployeesObtainer(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> execute (){
        Optional<List<Employee>> employees=repository.getAll();

        if(employees.isEmpty()){
            throw new EmployeeNotExist("No se han encontrado empleados");
        }
        return employees.get();
    }

}
