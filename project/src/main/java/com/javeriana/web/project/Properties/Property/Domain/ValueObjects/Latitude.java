package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class Latitude {
    private float value;

    public Latitude(){

    }

    public Latitude(float value) {
        this.value = value;
        this.validate(value);
    }

    private void validate(float value) {
        if(value<-90 || value>90) {
            throw new InvalidNumber("Invalid latitude number");
        }
    }

    public float value(){
        return this.value;
    }
}
