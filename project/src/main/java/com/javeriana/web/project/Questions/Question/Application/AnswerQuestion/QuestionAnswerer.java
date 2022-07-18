package com.javeriana.web.project.Questions.Question.Application.AnswerQuestion;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferDomainFinder;
import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import com.javeriana.web.project.Questions.Question.Domain.Services.QuestionDomainFinder;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.Answer;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

import java.util.Optional;

public class QuestionAnswerer {

    private QuestionRepository repository;
    private QuestionDomainFinder questionDomainFinder;
    private EventBus eventBus;


    public QuestionAnswerer(QuestionRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.questionDomainFinder = new QuestionDomainFinder(repository);
        this.eventBus = eventBus;

    }

    public Question execute(String questionId, String answer){
        Optional<Question> actualQuestion= questionDomainFinder.execute(questionId);
        Question question = actualQuestion.get();
        question.answerQuestion(new Answer(answer));
        repository.update(questionId,question);
        eventBus.publish(question.pullDomainEvents());
        return question;
    }
}
