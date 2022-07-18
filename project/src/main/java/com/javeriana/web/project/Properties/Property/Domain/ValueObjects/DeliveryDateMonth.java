package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.IntegerValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class DeliveryDateMonth extends IntegerValueObject {
    public DeliveryDateMonth (){
        super(0);
    }

    public DeliveryDateMonth (int value) {
        super(value);
        this.validate(value);
    }

    private void validate(int value) {
        this.numberRule(value);
    }

    private void numberRule(int value) {
        //if(value < 1 || value > 12) {
          //  throw new InvalidNumber("Invalid area number");
        //}
    }
}
