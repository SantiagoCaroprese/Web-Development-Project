package com.javeriana.web.project.Properties.Offer.Domain;

import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.*;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Shared.Bus.Aggregate.AggregateRoot;
import com.javeriana.web.project.Shared.Domain.Offers.OfferCreatorDomainEvent;
import com.javeriana.web.project.Shared.Domain.Offers.OfferDeleterDomainEvent;
import com.javeriana.web.project.Shared.Domain.Offers.OfferModifierDomainEvent;

import java.util.HashMap;
import java.util.Objects;

public class Offer extends AggregateRoot{
    private OfferId offerId;
    private PropertyId propertyId;
    private Price price;
    private Action action;

    public Offer() {
    }

    public Offer(OfferId offerId, PropertyId propertyId, Price price, Action action) {
        this.offerId = offerId;
        this.propertyId = propertyId;
        this.price = price;
        this.action = action;
    }

    public void crateOfferEvent(){
        this.record(new OfferCreatorDomainEvent(this.offerId.value(),this.price.value(),this.action.value(),this.propertyId.value()));
    }

    public void updateOffer(Price price) {
        this.price=price;
        this.record(new OfferModifierDomainEvent(this.offerId.value(),this.price.value(),this.action.value(),this.propertyId.value()));
    }

    public HashMap<String,String> data(){
        HashMap<String,String> data = new HashMap<String,String>(){{
            put("offerId",offerId.value());
            put("propertyId",propertyId.value());
            put("price",Integer.toString(price.value()));
            put("action",action.value());
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(offerId, offer.offerId) &&
                Objects.equals(propertyId, offer.propertyId) &&
                Objects.equals(price, offer.price) &&
                Objects.equals(action, offer.action);
    }

    public OfferId getOfferId() {
        return offerId;
    }

    public PropertyId getPropertyId() {
        return propertyId;
    }

    public Price getPrice() {
        return price;
    }

    public Action getAction() {
        return action;
    }

    public void deleteOffer(Offer offer) {
        offer.record(new OfferDeleterDomainEvent(this.offerId.value(),this.propertyId.value()));
    }

    public boolean validatePropertyId(String propertyId) {
        if(this.propertyId.value().equals(propertyId)){
            return true;
        }
        return false;
    }
}
