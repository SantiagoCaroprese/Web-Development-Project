package com.javeriana.web.project.Employees.Employee.Domain.Ports;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    void save(Employee employee);

    public Employee authenticate(String email, String password);

    public Employee getByEmail(String email);
    //TODO: Add other methods
    Optional<Employee> find (String employeeId);
    
    void update (String employeeId,Employee employee);
    void delete (Employee employee);
    Optional<List<Employee>> getAll ();
}
