package com.javeriana.web.project.Shared.Domain.Offers;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class OfferCreatorDomainEvent extends DomainEvent {

    private final double price;
    private final  String action;
    private final String propertyID;

    public OfferCreatorDomainEvent() {
        super(null);
        this.price = 0;
        this.action = null;
        this.propertyID = null;
    }

    public OfferCreatorDomainEvent(String aggregateId, double price, String action, String propertyID) {
        super(aggregateId);
        this.price = price;
        this.action = action;
        this.propertyID = propertyID;
    }

    public OfferCreatorDomainEvent(String aggregateId, String eventId, String occurredOn,double price, String action, String propertyID) {
        super(aggregateId, eventId, occurredOn);
        this.price = price;
        this.action = action;
        this.propertyID = propertyID;
    }

    @Override
    public String eventName() {
        return "offer.creator";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>(){{
            put("propertyID",propertyID);
            put("price",price);
            put("action",action);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new OfferCreatorDomainEvent(aggregateId, eventId, occurredOn,
                (double) body.get("price"),
                (String) body.get("action"),
                (String) body.get("propertyID"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferCreatorDomainEvent that = (OfferCreatorDomainEvent) o;
        return Double.compare(that.price, price) == 0  && Objects.equals(action, that.action) && Objects.equals(propertyID, that.propertyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, action, propertyID);
    }

    public double getPrice() {
        return price;
    }

    public String getAction() {
        return action;
    }

    public String getPropertyID() {
        return propertyID;
    }
}
