package com.javeriana.web.project.Properties.Property.Domain.Exceptions;

public class PropertyNotExist extends RuntimeException{
    public PropertyNotExist(String message) {
        super(message);
    }
}
