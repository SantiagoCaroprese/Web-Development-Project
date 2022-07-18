package com.javeriana.web.project.Properties.Property.Application.UpdateSerializedQuestion;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.PropertyDomainFinder;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.SerializedQuestion;

import java.util.Optional;

public final class UpdateSerializedQuestion {
    private PropertyRepository repository;
    private PropertyDomainFinder finder;

    public UpdateSerializedQuestion(PropertyRepository repository) {
        this.repository = repository;
        this.finder=new PropertyDomainFinder(repository);
    }

    public void execute(String propertyId, String questionId,String text,String date, String answer){
        Optional<Property> actualProperty=finder.execute(propertyId);
        actualProperty.get().answerQuestion(new SerializedQuestion(questionId,text,date,answer));
    }
}
