package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.IntegerValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class DeliveryDateDay extends IntegerValueObject {
    public DeliveryDateDay (){
        super(0);
    }

    public DeliveryDateDay (int value) {
        super(value);
        this.validate(value);
    }

    private void validate(int value) {
        this.numberRule(value);
    }

    private void numberRule(int value) {
        //if(value < 1 || value > 31) {
          //  throw new InvalidNumber("Invalid area number");
        //}
    }
}
