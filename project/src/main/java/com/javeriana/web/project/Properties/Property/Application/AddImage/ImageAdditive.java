package com.javeriana.web.project.Properties.Property.Application.AddImage;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Services.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.Image;

import java.util.Optional;

public class ImageAdditive {

    private PropertyRepository repository;
    private PropertyDomainFinder finder;

    public ImageAdditive(PropertyRepository repository) {
        this.repository = repository;
        this.finder=new PropertyDomainFinder(repository);
    }

    public void execute(String propertyId,String image){
        Optional<Property> property=finder.execute(propertyId);
        property.get().addImage(image);
        repository.update(propertyId,property.get());
    }
}
