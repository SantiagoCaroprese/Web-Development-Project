package com.javeriana.web.project.Properties.Property.Application.Find;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Services.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.PropertyId;

import java.util.Optional;

public class PropertyFinder {

    private PropertyDomainFinder finder;

    public PropertyFinder(PropertyRepository repository) {
        this.finder = new PropertyDomainFinder(repository);
    }

    public Property execute (String propertyId){
         Optional<Property> property = finder.execute(new PropertyId(propertyId).value());
         return property.get();
    }
}
