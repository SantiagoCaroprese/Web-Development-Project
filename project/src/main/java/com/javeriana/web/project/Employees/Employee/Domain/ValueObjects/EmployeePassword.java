package com.javeriana.web.project.Employees.Employee.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.StringValueObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EmployeePassword extends StringValueObject {

    private final int STRENGTH = 12;

    private EmployeePassword(){
        super("");
    }

    public EmployeePassword(String value) {
        super(value);
        this.validate(value);
        this.value = this.encode(value);
    }

    private void validate(String value) {
        this.lengthRule(value);
    }

    private void lengthRule(String value) {
        if(value.length() < 3 || value.length() > 200) {
            throw new InvalidLength("Invalid number of characters");
        }
    }

    private String encode(String value) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(STRENGTH);
        return encoder.encode(value);
    }
}
