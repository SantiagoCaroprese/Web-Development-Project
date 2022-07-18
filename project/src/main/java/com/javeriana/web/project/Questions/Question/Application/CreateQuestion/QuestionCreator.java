package com.javeriana.web.project.Questions.Question.Application.CreateQuestion;

import com.javeriana.web.project.Questions.Question.Domain.Exceptions.QuestionAlreadyExist;
import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import com.javeriana.web.project.Questions.Question.Domain.Services.QuestionDomainFinder;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

import java.time.LocalDate;

public class QuestionCreator {

    private QuestionRepository repository;
    private QuestionDomainFinder questionDomainFinder;
    private EventBus eventBus;

    public QuestionCreator(QuestionRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.questionDomainFinder = new QuestionDomainFinder(repository);
        this.eventBus = eventBus;
    }

    public void execute(String questionId, String propertyId, String text, LocalDate date){
        Question question = new Question(new QuestionId(questionId),new PropertyId(propertyId),new Text(text),new QuestionDate(date),new Answer(""));
        question.createQuestionEvent();
        repository.save(question);
        this.eventBus.publish(question.pullDomainEvents());
    }

    private void validate(String questionId){
        if(!questionDomainFinder.execute(questionId).isEmpty()){
            throw new QuestionAlreadyExist("Question with id "+questionId+ "Already exist");
        }
    }

}
