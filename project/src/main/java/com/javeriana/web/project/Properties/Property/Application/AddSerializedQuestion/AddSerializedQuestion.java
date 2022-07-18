package com.javeriana.web.project.Properties.Property.Application.AddSerializedQuestion;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.SerializedQuestion;

import java.time.LocalDate;
import java.util.Optional;


public class AddSerializedQuestion {
    private PropertyRepository repository;
    private PropertyDomainFinder finder;

    public AddSerializedQuestion(PropertyRepository repository) {
        this.repository = repository;
        this.finder = new PropertyDomainFinder(repository);
    }

    public void execute(String aggregateId, String propertyId, String text, LocalDate date, String answer) {
        Optional<Property> property=finder.execute(propertyId);
        property.get().addQuestion(new SerializedQuestion(aggregateId, text, date.toString(), answer));
        repository.update(propertyId,property.get());
    }
}
