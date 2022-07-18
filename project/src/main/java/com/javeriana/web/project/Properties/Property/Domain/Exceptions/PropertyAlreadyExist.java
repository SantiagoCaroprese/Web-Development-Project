package com.javeriana.web.project.Properties.Property.Domain.Exceptions;

public class PropertyAlreadyExist extends RuntimeException {
    public PropertyAlreadyExist(String message){
        super(message);
    }
}
