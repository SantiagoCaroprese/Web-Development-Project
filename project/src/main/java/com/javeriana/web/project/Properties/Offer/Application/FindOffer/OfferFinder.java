package com.javeriana.web.project.Properties.Offer.Application.FindOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferNotExist;
import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferDomainFinder;

import java.util.Optional;

public class OfferFinder {

    private OfferRepository repository;
    private OfferDomainFinder offerDomainFinder;

    public OfferFinder(OfferRepository repository) {
        this.repository = repository;
        this.offerDomainFinder = new OfferDomainFinder(repository);
    }

    public Offer execute(String offerId){
        try{
            Optional<Offer> actualOffer=offerDomainFinder.execute(offerId);
            return actualOffer.get();
        }catch(OfferNotExist e){

        }
        return null;
    }
}
