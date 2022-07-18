package com.javeriana.web.project.Properties.Offer.Domain.Services;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferNotExist;

import java.util.Optional;

public class OfferDomainFinder {

    private OfferRepository repository;

    public OfferDomainFinder(OfferRepository repository) {
        this.repository = repository;
    }

    public Optional<Offer> execute(String offerId){
        Optional<Offer> offer = repository.find(offerId);
        if(offer.isEmpty()){
            throw new OfferNotExist("Offer with id "+offerId+" not found");
        }
        return offer;
    }
}
