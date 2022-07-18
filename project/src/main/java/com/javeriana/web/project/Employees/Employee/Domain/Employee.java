package com.javeriana.web.project.Employees.Employee.Domain;

import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Bus.Aggregate.AggregateRoot;
import com.javeriana.web.project.Shared.Domain.Employees.EmployeeDeletedDomainEvent;

import java.util.HashMap;
import java.util.Objects;

public class Employee extends AggregateRoot {

    private EmployeeId employeeId;
    private EmployeeEmail employeeEmail;
    private EmployeePassword employeePassword;
    private EmployeeFirstName employeeFirstName;
    private EmployeeLastName employeeLastName;
    private EmployeeIsAdministrator employeeIsAdministrator;

    public Employee() {
    }

    public Employee(
            EmployeeId employeeId,
            EmployeeEmail employeeEmail,
            EmployeePassword employeePassword,
            EmployeeFirstName employeeFirstName,
            EmployeeLastName employeeLastName,
            EmployeeIsAdministrator employeeIsAdministrator
    ) {
        this.employeeId = employeeId;
        this.employeeEmail = employeeEmail;
        this.employeePassword = employeePassword;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeIsAdministrator = employeeIsAdministrator;
    }

    public void updateEmployee(EmployeeEmail employeeEmail,
                               EmployeePassword employeePassword,
                               EmployeeFirstName employeeFirstName,
                               EmployeeLastName employeeLastName,
                               EmployeeIsAdministrator employeeIsAdministrator){
        this.employeeEmail = employeeEmail;
        this.employeePassword = employeePassword;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeIsAdministrator = employeeIsAdministrator;
    }

    public HashMap<String,String> data(){
        HashMap<String,String> data = new HashMap<String,String>(){{
           put("id",employeeId.value());
           put("name",employeeFirstName.value());
           put("lastName",employeeLastName.value());
           put("email",employeeEmail.value());
            put("password",employeePassword.value());
           put("is_admin", employeeIsAdministrator.value().toString());
        }};

        return data;
    }

    public boolean equalsById(String otherId){
        return this.employeeId.equals(new EmployeeId(otherId));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(employeeEmail, employee.employeeEmail) && Objects.equals(employeePassword, employee.employeePassword) && Objects.equals(employeeFirstName, employee.employeeFirstName) && Objects.equals(employeeLastName, employee.employeeLastName) && Objects.equals(employeeIsAdministrator, employee.employeeIsAdministrator);
    }

    public static void deleteEmployee(Employee employee) {
        employee.record(new EmployeeDeletedDomainEvent(employee.employeeId.value()));
    }

}
