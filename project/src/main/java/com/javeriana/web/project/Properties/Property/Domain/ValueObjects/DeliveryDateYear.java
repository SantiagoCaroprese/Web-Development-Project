package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.IntegerValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class DeliveryDateYear extends IntegerValueObject {
    public DeliveryDateYear (){
        super(0);
    }

    public DeliveryDateYear (int value) {
        super(value);
        this.validate(value);
    }

    private void validate(int value) {
        this.numberRule(value);
    }

    private void numberRule(int value) {
        //if(value < 0000 || value > 9999) {
          //  throw new InvalidNumber("Invalid area number");
        //}
    }
}
