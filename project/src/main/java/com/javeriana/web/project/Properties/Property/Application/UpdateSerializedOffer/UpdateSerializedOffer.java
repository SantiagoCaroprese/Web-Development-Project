package com.javeriana.web.project.Properties.Property.Application.UpdateSerializedOffer;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Services.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.SerializedOffer;

import java.util.Optional;

public class UpdateSerializedOffer {
    private PropertyRepository repository;
    private PropertyDomainFinder finder;

    public UpdateSerializedOffer(PropertyRepository repository) {
        this.repository = repository;
        this.finder=new PropertyDomainFinder(repository);
    }

    public void execute(String offerId, String propertyId, double price, String action){
        Optional<Property> actualProperty=finder.execute(propertyId);
        actualProperty.get().modifyOffer(new SerializedOffer(offerId,price,action));
        repository.update(propertyId,actualProperty.get());
    }
}
