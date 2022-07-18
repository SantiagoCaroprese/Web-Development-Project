package com.javeriana.web.project.Properties.Property.Application.Delete;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;
import java.util.Optional;

public class PropertyDeleter {
    private PropertyRepository repository;
    private PropertyDomainFinder finder;
    private EventBus eventBus;

    public PropertyDeleter(PropertyRepository repository, EventBus eventBus){
        this.repository = repository;
        this.eventBus = eventBus;
        this.finder = new PropertyDomainFinder(repository);
    }

    public void execute(String propertyId){
        Optional<Property> actualProperty = finder.execute(propertyId);
        Property deleteProperty = actualProperty.get();
        deleteProperty.delete(new PropertyId(propertyId));
        this.eventBus.publish(deleteProperty.pullDomainEvents());
        this.repository.delete(deleteProperty);
    }
}
