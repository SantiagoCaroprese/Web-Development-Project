package com.javeriana.web.project.Properties.Property.Domain.Services;

import com.javeriana.web.project.Properties.Property.Domain.Exceptions.NoPropertiesFoundException;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Questions.Question.Domain.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyFilter {

    private PropertyRepository repository;

    public PropertyFilter(PropertyRepository repository) {
        this.repository = repository;
    }

    public List<Property> execute(List<String> propiedades,String propertyType,  String city,
                                  int bedRoomsNumber, int bathRoomNumber, String propertyCondition){
        Optional<List<Property>> properties = repository.filter(propiedades ,propertyType,city,
                bedRoomsNumber,bathRoomNumber,propertyCondition);

        if(properties.get().isEmpty()){
            throw new NoPropertiesFoundException("No se encontraron propiedades con los parametros especificados");
        }

        return properties.get();
    }
}
