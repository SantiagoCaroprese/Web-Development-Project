package com.javeriana.web.project.Properties.Offer.Domain.Ports;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Property.Domain.Property;

import java.util.List;
import java.util.Optional;

public interface OfferRepository {
    void save(Offer offer);
    Optional<Offer> find(String offerId);
    Offer update(String offerId,Offer offer);
    void delete(Offer offer);
    Optional<List<String>> filter(int priceLowerLimit, int priceUpperLimit, String action);
    Optional<List<Offer>> all();

    //TODO: Add other methods
}
