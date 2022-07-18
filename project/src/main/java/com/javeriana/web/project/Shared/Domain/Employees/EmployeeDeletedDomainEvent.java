package com.javeriana.web.project.Shared.Domain.Employees;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class EmployeeDeletedDomainEvent extends DomainEvent {

    public EmployeeDeletedDomainEvent() {
    }

    public EmployeeDeletedDomainEvent(String aggregateId) {
        super(aggregateId);
    }

    public EmployeeDeletedDomainEvent(String aggregateId, String eventId, String occurredOn) {
        super(aggregateId, eventId, occurredOn);
    }

    @Override
    public String eventName() {
        return "employee.deleted";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>();
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new EmployeeDeletedDomainEvent(aggregateId,
                eventId,
                occurredOn);
    }

}
