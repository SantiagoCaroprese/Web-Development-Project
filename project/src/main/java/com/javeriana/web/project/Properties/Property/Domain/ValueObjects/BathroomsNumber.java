package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.IntegerValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class BathroomsNumber extends IntegerValueObject {

    public BathroomsNumber(){
        super(0);
    }

    public BathroomsNumber(int value) {
        super(value);
        this.validate(value);
    }

    private void validate(int value) {
        this.numberRule(value);
    }

    private void numberRule(int value) {
        if(value < 1 || value > 20) {
            throw new InvalidNumber("Invalid number of rooms");
        }
    }
}
