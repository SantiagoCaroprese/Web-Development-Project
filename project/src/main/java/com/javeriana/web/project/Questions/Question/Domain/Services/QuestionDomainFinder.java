package com.javeriana.web.project.Questions.Question.Domain.Services;

import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.OfferNotExist;
import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;

import java.util.Optional;

public class QuestionDomainFinder {

    QuestionRepository repository;

    public QuestionDomainFinder(QuestionRepository repository) {
        this.repository = repository;
    }

    public Optional<Question> execute(String questionId){
        Optional<Question> question = repository.find(questionId);
        if(question.isEmpty()){
            throw new OfferNotExist("Question with id: "+questionId+" not exist");
        }
        return question;
    }

}
