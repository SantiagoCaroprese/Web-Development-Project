package com.javeriana.web.project.Employees.Employee.Application.GetAll;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllEmployeesResponse {

    private List<Employee> employees;

    public GetAllEmployeesResponse(List<Employee> employees) {
        this.employees = employees;
    }

    public List<HashMap> response() {
        List<HashMap> response = employees.stream().map(a -> a.data()).collect(Collectors.toList());
        return response;
    }
}