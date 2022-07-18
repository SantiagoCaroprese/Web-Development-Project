package com.javeriana.web.project.Shared.Domain.Offers;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class OfferModifierDomainEvent extends DomainEvent {

    private final double price;
    private final  String action;
    private final String propertyID;

    public OfferModifierDomainEvent() {
        super(null);
        this.price = 0;
        this.action = null;
        this.propertyID = null;
    }

    public OfferModifierDomainEvent(String aggregateId, double price, String action, String propertyID) {
        super(aggregateId);
        this.price = price;
        this.action = action;
        this.propertyID = propertyID;
    }

    public OfferModifierDomainEvent(String aggregateId, String eventId, String occurredOn, double price, String action, String propertyID) {
        super(aggregateId, eventId, occurredOn);
        this.price = price;
        this.action = action;
        this.propertyID = propertyID;
    }

    @Override
    public String eventName() {
        return "offer.modifier";
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
        return new OfferModifierDomainEvent(aggregateId, eventId, occurredOn,
            (double) body.get("price"),
            (String) body.get("action"),
            (String) body.get("propertyID"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferModifierDomainEvent that = (OfferModifierDomainEvent) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(action, that.action) && Objects.equals(propertyID, that.propertyID);
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
