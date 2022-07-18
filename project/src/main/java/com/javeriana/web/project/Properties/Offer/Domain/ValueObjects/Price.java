package com.javeriana.web.project.Properties.Offer.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.IntegerValueObject;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class Price extends IntegerValueObject {

    public Price(int value) {
        super(value);
        this.validate(value);
    }

    public Price() {
        super(0);
    }

    private void validate(int value) {
        this.numberRule(value);
    }

    private void numberRule(int value) {
        if(value < 10000 || value > Integer.MAX_VALUE) {
            throw new InvalidNumber("Invalid price number");
        }
    }
}
