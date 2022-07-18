package com.javeriana.web.project.Shared.Infrastructure.Bus.Event.Spring;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(List<DomainEvent> eventList) {
        eventList.forEach(this::publish);
    }

    private void publish(final DomainEvent event){
        this.publisher.publishEvent(event);
    }
}
