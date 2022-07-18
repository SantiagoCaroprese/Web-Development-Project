package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.DateValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

import java.time.LocalDate;

public class DeliveryDate extends DateValueObject {

    public DeliveryDate(){
        super(LocalDate.of(0001,01,01));
    }

    public DeliveryDate(LocalDate value) {
        super(value);
        this.validate(value);
    }

    private void validate(LocalDate value) {
        this.numberRule(value);
    }

    private void numberRule(LocalDate value) {
        if(value.isBefore(LocalDate.now())) {
            throw new InvalidNumber("Invalid date");
        }
    }
}
