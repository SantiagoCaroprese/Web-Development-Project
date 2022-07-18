package com.javeriana.web.project.Shared.Domain.Properties;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;
import java.io.Serializable;
import java.util.HashMap;

public final class PropertyDeleterDomainEvent extends DomainEvent {

    public PropertyDeleterDomainEvent(String aggregateId, String eventId, String occurredOn) {
        super(aggregateId, eventId, occurredOn);
    }

    public PropertyDeleterDomainEvent(String aggregateId) {
        super(aggregateId);
    }

    public PropertyDeleterDomainEvent() {
        super();
    }

    @Override
    public String eventName() {
        return "property.deleter";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{

        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new PropertyDeleterDomainEvent(aggregateId,eventId,occurredOn);
    }
}
