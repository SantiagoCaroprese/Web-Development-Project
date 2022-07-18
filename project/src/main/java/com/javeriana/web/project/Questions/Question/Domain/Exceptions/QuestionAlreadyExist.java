package com.javeriana.web.project.Questions.Question.Domain.Exceptions;

public class QuestionAlreadyExist extends RuntimeException{
    public QuestionAlreadyExist(String message){
        super(message);
    }
}
