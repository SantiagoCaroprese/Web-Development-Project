package com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class AssignedEmployee {

    private String employeeId;
    private String email;
    private String firstName;
    private String lastName;

    public AssignedEmployee(String employeeId, String email, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", employeeId);
            put("email", email);
            put("firstName", firstName);
            put("lastName", lastName);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignedEmployee that = (AssignedEmployee) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, email, firstName, lastName);
    }

    public AssignedEmployee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
