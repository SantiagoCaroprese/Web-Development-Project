package com.javeriana.web.project.Properties.Property.Domain.Ports;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PropertyRepository {
    void save(Property property);
    Optional<Property> find(String propertyId);
    Optional<List<Property>> filter(List<String> idPropiedades, String propertyType, String city,
                          int bedRoomsNumber, int bathRoomNumber, String propertyCondition);
    Optional<List<Property>> all();

    //TODO: Add other methods
    void update (String propertyId, Property property);
    void delete (Property property);
}
