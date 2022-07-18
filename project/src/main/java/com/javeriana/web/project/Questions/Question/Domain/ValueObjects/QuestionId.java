package com.javeriana.web.project.Questions.Question.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.CustomUUID;

public class QuestionId extends CustomUUID {

    public QuestionId(){

    }
    public QuestionId(String value){super(value);}
}
