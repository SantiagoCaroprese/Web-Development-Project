package com.javeriana.web.project.Properties.Property.Infrastructure.DomainEventSubcribers;

import com.javeriana.web.project.Properties.Property.Application.AddSerializedOffer.AddSerializedOffer;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Offers.OfferCreatorDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({OfferCreatorDomainEvent.class})
public final class AddSerializedOfferOnOfferCreated {

    private AddSerializedOffer addSerializedOffer;

    public AddSerializedOfferOnOfferCreated(AddSerializedOffer addSerializedOffer) {
        this.addSerializedOffer = addSerializedOffer;
    }

    @EventListener
    public void on(OfferCreatorDomainEvent event){
        addSerializedOffer.execute(event.aggregateId(),event.getPropertyID(),event.getPrice(),event.getAction());
    }
}
