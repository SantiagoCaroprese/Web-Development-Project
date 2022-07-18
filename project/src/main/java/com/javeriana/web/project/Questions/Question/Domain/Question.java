package com.javeriana.web.project.Questions.Question.Domain;

import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Bus.Aggregate.AggregateRoot;
import com.javeriana.web.project.Shared.Domain.Questions.QuestionAnsweredDomainEvent;
import com.javeriana.web.project.Shared.Domain.Questions.QuestionCreatorDomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class Question extends AggregateRoot implements Serializable {


    private QuestionId questionId;
    private PropertyId propertyId;
    private QuestionDate date;
    private Text text;
    private Answer answer;

    public Question(){
        this.date = null;
        this.propertyId = null;
        this.questionId = null;
        this.text = null;
        this.answer = null;
    }

    public Question(QuestionId questionId, PropertyId propertyId, Text text, QuestionDate date,Answer answer) {
        this.date = date;
        this.propertyId = propertyId;
        this.questionId = questionId;
        this.text = text;
        this.answer = answer;
    }

    public void createQuestionEvent(){
        this.record(new QuestionCreatorDomainEvent(this.questionId.value(),this.propertyId.value(),this.text.value(),this.date.value(),this.answer.value()));
    }

    public Question(QuestionId questionId, PropertyId propertyId, Text text, QuestionDate date) {
        this.date = date;
        this.propertyId = propertyId;
        this.questionId = questionId;
        this.text = text;
        this.answer = new Answer("");
        this.record(new QuestionCreatorDomainEvent(questionId.value(),propertyId.value(),text.value(),date.value(),""));
    }

    public Question askQuestion(QuestionId questionId, PropertyId propertyId,QuestionDate date, Text text){
        Question question = new Question(questionId,propertyId,text, date);
        this.record(new QuestionCreatorDomainEvent(questionId.value(),propertyId.value(),text.value(),date.value(),""));
        return question;
    }

    public QuestionDate getDate() {
        return date;
    }

    public PropertyId getPropertyId() {
        return propertyId;
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public Text getText() {
        return text;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void answerQuestion(Answer answer){
        this.answer = answer;
        this.record(new QuestionAnsweredDomainEvent(questionId.value(),propertyId.value(),text.value(),date.value(),""));
    }

    public HashMap<String, String> data() {
        HashMap<String,String> data = new HashMap<String,String>(){{
            put("id",getQuestionId().value());
            put("propertyid",getPropertyId().value());
            put("text",getText().value());
            put("date",getDate().value().toString());
            put("answer",getAnswer().toString());
        }};
        return data;
    }
}
