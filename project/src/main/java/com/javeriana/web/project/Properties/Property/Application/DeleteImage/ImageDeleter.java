package com.javeriana.web.project.Properties.Property.Application.DeleteImage;

import com.javeriana.web.project.Properties.Property.Domain.Exceptions.ImageNotFoundException;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Services.PropertyDomainFinder;

import java.util.Optional;

public class ImageDeleter {

    private PropertyRepository repository;
    private PropertyDomainFinder finder;

    public ImageDeleter(PropertyRepository repository) {
        this.repository = repository;
        this.finder=new PropertyDomainFinder(repository);
    }

    public void execute(String propertyId,String imageId){
        Optional<Property> property=finder.execute(propertyId);
        if(!property.get().deleteImage(imageId)){
            throw new ImageNotFoundException("Image in position "+imageId+" not found in property with id "+propertyId);
        }
        repository.update(propertyId,property.get());
    }
}
