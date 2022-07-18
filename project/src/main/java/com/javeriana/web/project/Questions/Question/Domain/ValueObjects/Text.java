package com.javeriana.web.project.Questions.Question.Domain.ValueObjects;

import com.javeriana.web.project.Shared.Domain.InvalidLength;
import com.javeriana.web.project.Shared.Domain.StringValueObject;

public class Text extends StringValueObject {

    public Text(){

    }

    public Text(String value){
        super(value);
        this.validate(value);
    }

    private void validate(String value) {
        this.lengthRule(value);
    }
    private void lengthRule(String value) {
        if(value.length() < 1 || value.length() > 800) {
            throw new InvalidLength("Invalid number of characters");
        }
    }
}
