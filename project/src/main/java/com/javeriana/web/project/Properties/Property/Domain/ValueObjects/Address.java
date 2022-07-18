package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class Address extends StringValueObject {

    public Address(){

    }

    public Address(String value) {
        super(value);
        this.validate(value);
    }

    private void validate(String value) {
        this.lengthRule(value);
    }

    private void lengthRule(String value) {
        if(value.length() < 1 || value.length() > 50) {
            throw new InvalidLength("Invalid number of characters");
        }
    }
}
