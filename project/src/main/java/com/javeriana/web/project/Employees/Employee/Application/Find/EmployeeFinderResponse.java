package com.javeriana.web.project.Employees.Employee.Application.Find;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Shared.Application.Response;

import java.util.HashMap;

public class EmployeeFinderResponse implements Response {
    private Employee employee;

    public EmployeeFinderResponse(Employee employee){
        this.employee = employee;
    }

    public HashMap response(){
        HashMap response = this.employee.data();
        response.remove("id");
        return response;
    }
}
