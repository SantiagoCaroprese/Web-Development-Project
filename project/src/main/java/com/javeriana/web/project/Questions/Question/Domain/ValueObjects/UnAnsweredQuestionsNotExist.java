package com.javeriana.web.project.Questions.Question.Domain.ValueObjects;

public class UnAnsweredQuestionsNotExist extends RuntimeException{
    public UnAnsweredQuestionsNotExist(String message) {
        super(message);
    }
}
