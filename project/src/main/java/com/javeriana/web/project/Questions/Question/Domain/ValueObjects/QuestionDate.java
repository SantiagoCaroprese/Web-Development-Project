package com.javeriana.web.project.Questions.Question.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.DateValueObject;

import java.time.LocalDate;
import java.util.Date;

public class QuestionDate extends DateValueObject {

    public QuestionDate(){
        super(LocalDate.of(0001,01,01));
    }

    public QuestionDate(LocalDate value){super(value);}
}
