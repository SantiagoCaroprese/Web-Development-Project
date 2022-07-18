package com.javeriana.web.project.Properties.Property.Application.Create;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyAlreadyExist;
import com.javeriana.web.project.Properties.Property.Domain.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.Exceptions.PropertyNotExist;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import java.time.LocalDate;


public class PropertyCreator {
    private PropertyRepository repository;
    private PropertyDomainFinder finder;

    public PropertyCreator(PropertyRepository repository) {
        this.repository = repository;
        this.finder = new PropertyDomainFinder(repository);
    }

    public void execute(String propertyId, String address, String propertyType, String city, String description, int bedroomsNumber, int bathroomsNumber, int privateArea, int builtArea, int serviceLevel, String condition, int deliveryDateYear, int deliveryDateMonth, int deliveryDateDay, float latitude, float longitude){
        this.validate(propertyId);
        Property property = Property.create(new PropertyId(propertyId),new Address(address),new PropertyType(propertyType),new City(city),new Description(description),new BedroomsNumber(bedroomsNumber),new BathroomsNumber(bathroomsNumber),new PrivateArea(privateArea),new BuiltArea(builtArea),new ServiceLevel(serviceLevel),new Condition(condition),new DeliveryDate(LocalDate.of(deliveryDateYear,deliveryDateMonth,deliveryDateDay)),new Latitude(latitude),new Longitude(longitude));
        repository.save(property);
    }

    private void validate(String propertyId){
        try{
            this.finder.execute(propertyId);
            throw new PropertyAlreadyExist("La propiedad con el ID: "+propertyId+ " ya existe");
        }
        catch (PropertyNotExist exception){

        }
    }
}
