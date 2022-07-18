package com.javeriana.web.project.Properties.Property.Application.Update;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyConditionEnum;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyTypeEnum;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class PropertyModifier {

    private PropertyRepository repository;
    private PropertyDomainFinder finder;
    private EventBus eventBus;

    public PropertyModifier(PropertyRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.finder = new PropertyDomainFinder(repository);
    }

    public void execute(String propertyId, String address, String propertyType, String city, String description, int bedroomsNumber, int bathroomsNumber, int privateArea, int builtArea, int serviceLevel, String condition, int deliveryDateYear,int deliveryDateMonth,int deliveryDateDay, float latitude, float longitude){

        Optional<Property> actualProperty = finder.execute(propertyId);
        Property oldProperty = actualProperty.get();
        oldProperty.updateProperty(new Address(address),new PropertyType(propertyType),new City(city),new Description(description),new BedroomsNumber(bedroomsNumber),new BathroomsNumber(bathroomsNumber),new PrivateArea(privateArea),new BuiltArea(builtArea),new ServiceLevel(serviceLevel),new Condition(condition),new DeliveryDate(LocalDate.of(deliveryDateYear,deliveryDateMonth,deliveryDateDay)),new Latitude(latitude),new Longitude(longitude));
        this.repository.update(propertyId, oldProperty);
        this.eventBus.publish(oldProperty.pullDomainEvents());
    }

}
