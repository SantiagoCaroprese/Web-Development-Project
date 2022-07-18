package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.IntegerValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class PrivateArea extends IntegerValueObject {

    public PrivateArea(){
        super(0);
    }

    public PrivateArea(int value) {
        super(value);
        this.validate(value);
    }

    private void validate(int value) {
        this.numberRule(value);
    }

    private void numberRule(int value) {
        if(value < 5 || value > 1000000000) {
            throw new InvalidNumber("Invalid area number");
        }
    }
}
