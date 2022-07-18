package com.javeriana.web.project.Properties.Offer.Application.DeleteOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferNotExist;
import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.PropertyNotMatch;
import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferDomainFinder;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferPropertyMatcher;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

import java.util.Optional;

public class OfferDeleter {

    private OfferRepository repository;
    private OfferDomainFinder offerDomainFinder;
    private EventBus eventBus;
    private OfferPropertyMatcher offerPropertyMatcher;

    public OfferDeleter(OfferRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.offerDomainFinder = new OfferDomainFinder(repository);
        this.eventBus=eventBus;
        this.offerPropertyMatcher=new OfferPropertyMatcher(repository);
    }

    public void execute(String offerId, String propertyId){
        Optional<Offer> actualOffer=offerDomainFinder.execute(offerId);
        Offer offer=actualOffer.get();
        offerPropertyMatcher.execute(offer,propertyId);
        offer.deleteOffer(offer);
        repository.delete(offer);
        this.eventBus.publish(offer.pullDomainEvents());

    }
}
