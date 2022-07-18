package com.javeriana.web.project.Properties.Property.Application.FilterProperties;

import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Services.PropertyFilter;


import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class FilterProperties {

    private PropertyRepository repository;
    private PropertyFilter propertiesFilter;

    public FilterProperties(PropertyRepository repository) {
        this.repository = repository;
        this.propertiesFilter = new PropertyFilter(repository);
    }

    public List<Property> execute(List<String> propiedades,String propertyType, String city,
                                  int bedRoomsNumber, int bathRoomNumber, String propertyCondition
                                  ){
        return propertiesFilter.execute(propiedades,propertyType,city,
                bedRoomsNumber,bathRoomNumber,propertyCondition
        );
    }
}
