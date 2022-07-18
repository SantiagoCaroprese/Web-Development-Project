package com.javeriana.web.project.Shared.Domain.Offers;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class OfferDeleterDomainEvent extends DomainEvent {

    private final String propertyID;

    public OfferDeleterDomainEvent() {
        this.propertyID=null;
    }

    public OfferDeleterDomainEvent(String aggregateId, String propertyID) {
        super(aggregateId);
        this.propertyID=propertyID;
    }

    public OfferDeleterDomainEvent(String aggregateId, String eventId, String occurredOn, String propertyID) {
        super(aggregateId, eventId, occurredOn);
        this.propertyID = propertyID;
    }

    @Override
    public String eventName() {
        return "offer.deleter";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>(){{
            put("propertyID",propertyID);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new OfferDeleterDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("propertyID"));
    }

    public String getPropertyID() {
        return propertyID;
    }
}
