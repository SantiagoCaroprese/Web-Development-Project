package com.javeriana.web.project.Properties.Property.Infrastructure.DomainEventSubcribers;

import com.javeriana.web.project.Properties.Property.Application.AddSerializedQuestion.AddSerializedQuestion;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Questions.QuestionCreatorDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({QuestionCreatorDomainEvent.class})
public final class AddSerializedQuestionOnQuestionCreated {

    private AddSerializedQuestion addSerializedQuestion;

    public AddSerializedQuestionOnQuestionCreated(AddSerializedQuestion addSerializedQuestion) {
        this.addSerializedQuestion = addSerializedQuestion;
    }

    @EventListener
    public void on(QuestionCreatorDomainEvent event){
        addSerializedQuestion.execute(event.aggregateId(), event.getPropertyId(), event.getText(), event.getDate(), event.getAnswer());
    }
}
