package com.javeriana.web.project.Properties.Property.Infrastructure.DomainEventSubcribers;

import com.javeriana.web.project.Properties.Property.Application.UpdateSerializedOffer.UpdateSerializedOffer;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Offers.OfferModifierDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({OfferModifierDomainEvent.class})
public final class UpdateSerializedOfferOnOfferModified {

    private UpdateSerializedOffer updateSerializedOffer;

    public UpdateSerializedOfferOnOfferModified(UpdateSerializedOffer serializedOfferModifier) {
        this.updateSerializedOffer = serializedOfferModifier;
    }

    @EventListener
    public void on(OfferModifierDomainEvent event){
        updateSerializedOffer.execute(event.aggregateId(),event.getPropertyID(),event.getPrice(),event.getAction());
    }
}
