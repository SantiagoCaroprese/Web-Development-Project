package com.javeriana.web.project.Employees.Employee.Application.DeleteEmployee;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

import java.util.Optional;

public class EmployeeDeleter {

    private EmployeeRepository employeeRepository;
    private EventBus eventBus;

    public EmployeeDeleter(EmployeeRepository employeeRepository, EventBus eventBus) {
        this.employeeRepository = employeeRepository;
        this.eventBus = eventBus;
    }

    public void execute(String id) {
        Optional<Employee> selectedEmployee = employeeRepository.find(id);
        if(selectedEmployee.isEmpty()) {
            throw new EmployeeNotExist("Employee does not exist");
        }
        Employee employee = selectedEmployee.get();
        Employee.deleteEmployee(employee);
        employeeRepository.delete(employee);
        this.eventBus.publish(employee.pullDomainEvents());
    }
}
