package com.javeriana.web.project.Properties.Offer.Domain.Exeptions;

public class PropertyNotFound extends RuntimeException{
    public PropertyNotFound(String message) {
        super(message);
    }
}
