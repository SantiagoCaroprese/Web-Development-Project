package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.Properties.PropertyConditionEnum;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class Condition extends StringValueObject {

    public Condition(){

    }
    public Condition(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
