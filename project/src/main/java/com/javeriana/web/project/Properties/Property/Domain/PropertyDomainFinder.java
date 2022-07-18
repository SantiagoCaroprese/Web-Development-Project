package com.javeriana.web.project.Properties.Property.Domain;

import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyNotExist;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import java.util.Optional;

public class PropertyDomainFinder {

    private PropertyRepository repository;

    public PropertyDomainFinder(PropertyRepository repository) {
        this.repository = repository;
    }

    public Optional<Property> execute (String propertyId){
        Optional<Property> property = repository.find(propertyId);

        if(property.isEmpty()){
            throw new PropertyNotExist("La propiedad con el id: " +propertyId+ " no existe.");
        }

        return property;
    }
}
