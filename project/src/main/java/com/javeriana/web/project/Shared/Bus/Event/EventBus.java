package com.javeriana.web.project.Shared.Bus.Event;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> eventList);
}
