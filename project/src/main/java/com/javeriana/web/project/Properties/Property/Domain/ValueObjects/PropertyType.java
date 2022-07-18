package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.Properties.PropertyTypeEnum;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class PropertyType extends StringValueObject {

    public PropertyType(){

    }

    public PropertyType(String value) {
        this.value = value;
    }

    public String value(){
        return this.value;
    }
}
