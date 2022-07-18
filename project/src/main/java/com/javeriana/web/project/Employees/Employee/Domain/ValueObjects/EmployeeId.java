package com.javeriana.web.project.Employees.Employee.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.CustomUUID;

public class EmployeeId extends CustomUUID {

    public EmployeeId(String value) {
        super(value);
    }

    public EmployeeId() {
    }

}
