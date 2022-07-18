package com.javeriana.web.project.Properties.Offer.Domain.Services;

import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.PropertyNotMatch;
import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;

public class OfferPropertyMatcher {

    private OfferRepository offerRepository;

    public OfferPropertyMatcher(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public boolean execute(Offer offer, String propertyId){
        if(!offer.validatePropertyId(propertyId)){
            throw new PropertyNotMatch("Property ID does not match with offer ID");
        }
        return true;
    }
}
