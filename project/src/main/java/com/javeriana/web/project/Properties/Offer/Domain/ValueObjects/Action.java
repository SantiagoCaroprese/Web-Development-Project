package com.javeriana.web.project.Properties.Offer.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.Offers.OfferActionEnum;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class Action extends StringValueObject {

    public Action(String value) {
        super(value);
    }

    public Action() {
    }

    public String value(){
        return this.value;
    }
}
