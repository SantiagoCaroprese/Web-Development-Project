package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class Description extends StringValueObject {

    public Description(){

    }

    public Description(String value) {
        super(value);
        this.validate(value);
    }

    private void validate(String value) {
        this.lengthRule(value);
    }

    private void lengthRule(String value) {
        if(value.length() < 1 || value.length() > 500) {
            throw new InvalidLength("Invalid number of characters");
        }
    }
}
