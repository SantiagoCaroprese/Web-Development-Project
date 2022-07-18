package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidNumber;

//See Singed degrees
public class Location {
    private Long latitude;
    private Long longitude;

    public Location(){

    }

    public Location(Long latitude, Long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.validate(latitude,longitude);
    }

    private void validate(Long latitude, Long longitude) {
        if(latitude<-90 || latitude>90){
            throw new InvalidNumber("Invalid latitude number");
        }else if(longitude<-180 || longitude>180){
            throw new InvalidNumber("Invalid longitude number");
        }
    }

    public Long latitude(){
        return this.latitude;
    }

    public Long longitude(){
        return this.longitude;
    }
}
