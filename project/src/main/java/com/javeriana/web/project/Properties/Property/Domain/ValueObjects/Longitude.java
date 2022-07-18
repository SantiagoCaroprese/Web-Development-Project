package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidNumber;

public class Longitude {
    private float value;

    public Longitude(){

    }

    public Longitude(float value) {
        this.value = value;
        this.validate(value);
    }

    private void validate(float value) {
        if(value<-180 || value>180){
            throw new InvalidNumber("Invalid longitude number");
        }
    }

    public float value(){
        return this.value;
    }
}
