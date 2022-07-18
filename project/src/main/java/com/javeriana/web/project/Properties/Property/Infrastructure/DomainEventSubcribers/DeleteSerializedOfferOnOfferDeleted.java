package com.javeriana.web.project.Properties.Property.Infrastructure.DomainEventSubcribers;

import com.javeriana.web.project.Properties.Property.Application.DeleteSerializedOffer.DeleteSerializedOffer;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Offers.OfferCreatorDomainEvent;
import com.javeriana.web.project.Shared.Domain.Offers.OfferDeleterDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({OfferDeleterDomainEvent.class})
public class DeleteSerializedOfferOnOfferDeleted {

    private DeleteSerializedOffer deleteSerializedOffer;

    public DeleteSerializedOfferOnOfferDeleted(DeleteSerializedOffer deleteSerializedOffer) {
        this.deleteSerializedOffer = deleteSerializedOffer;
    }

    @EventListener
    public void on(OfferDeleterDomainEvent event){
        deleteSerializedOffer.execute(event.aggregateId(),event.getPropertyID());
    }
}
