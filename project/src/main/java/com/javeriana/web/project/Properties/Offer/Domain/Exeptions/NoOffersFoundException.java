package com.javeriana.web.project.Properties.Offer.Domain.Exeptions;

public class NoOffersFoundException extends RuntimeException{
    public NoOffersFoundException(String message) {
        super(message);
    }
}
