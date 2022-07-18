package com.javeriana.web.project.Employees.Employee.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.BooleanValueObject;

public class EmployeeIsAdministrator extends BooleanValueObject {

    public EmployeeIsAdministrator(Boolean value) {
        super(value);
    }

    public EmployeeIsAdministrator() {
    }

}
