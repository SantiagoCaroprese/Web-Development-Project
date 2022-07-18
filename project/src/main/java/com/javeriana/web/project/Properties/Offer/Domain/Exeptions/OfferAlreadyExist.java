package com.javeriana.web.project.Properties.Offer.Domain.Exeptions;

public class OfferAlreadyExist extends RuntimeException{
    public OfferAlreadyExist(String message) {
        super(message);
    }
}
