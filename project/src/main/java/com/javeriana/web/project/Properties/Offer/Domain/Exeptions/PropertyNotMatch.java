package com.javeriana.web.project.Properties.Offer.Domain.Exeptions;

public class PropertyNotMatch  extends RuntimeException{
    public PropertyNotMatch(String message) {
        super(message);
    }
}
