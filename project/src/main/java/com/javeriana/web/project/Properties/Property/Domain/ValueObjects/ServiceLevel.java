package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.IntegerValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class ServiceLevel extends IntegerValueObject {

    public ServiceLevel(){
        super(0);
    }

    public ServiceLevel(int value) {
        super(value);
        this.validate(value);
    }

    private void validate(int value) {
        this.numberRule(value);
    }

    private void numberRule(int value) {
        if(value < 1 || value > 6) {
            throw new InvalidNumber("Invalid service level");
        }
    }
}
