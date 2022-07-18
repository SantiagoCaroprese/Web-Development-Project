package com.javeriana.web.project.Shared.Domain.Questions;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;
import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class QuestionCreatorDomainEvent extends DomainEvent {


    private final String propertyId;
    private final String text;
    private final LocalDate date;
    private final String answer;

    public QuestionCreatorDomainEvent(){
        super(null);

        this.propertyId = null;
        this.text = null;
        this.date = null;
        this.answer = null;
    }

    public QuestionCreatorDomainEvent(String aggregateId, String propertyId, String text, LocalDate date, String answer) {
        super(aggregateId);

        this.propertyId = propertyId;
        this.text = text;
        this.date = date;
        this.answer = answer;
    }

    public QuestionCreatorDomainEvent(String aggregateId, String eventId, String occurredOn, String propertyId, String text, LocalDate date, String answer) {
        super(aggregateId, eventId, occurredOn);
        this.propertyId = propertyId;
        this.text = text;
        this.date = date;
        this.answer = answer;
    }

    @Override
    public String eventName(){return "Question.creator";}



    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("propertyId",propertyId);
            put("text",text);
            put("date",date);
            put("answer",answer);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new QuestionCreatorDomainEvent(aggregateId,eventId,occurredOn,
                (String) body.get("propertyId"),
                (String) body.get("text"),
                (LocalDate) body.get("date"),
                (String) body.get("answer"));
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionCreatorDomainEvent that = (QuestionCreatorDomainEvent) o;
        return Objects.equals(that.answer, answer) && Objects.equals(propertyId, that.propertyId) && Objects.equals(text, that.text);

    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyId, text, date, answer);
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAnswer() {
        return answer;
    }
}
