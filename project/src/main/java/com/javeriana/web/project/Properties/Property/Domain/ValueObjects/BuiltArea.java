package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.IntegerValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class BuiltArea extends IntegerValueObject {
    public BuiltArea(){
        super(0);
    }

    public BuiltArea(int value) {
        super(value);
        this.validate(value);
    }

    private void validate(int value) {
        this.numberRule(value);
    }

    private void numberRule(int value) {
        if(value < 5 || value > 1000000) {
            throw new InvalidNumber("Invalid area number");
        }
    }
}
