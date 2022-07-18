package com.javeriana.web.project.Shared.Domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber extends StringValueObject{

    public PhoneNumber(String value) {
        super(value);
        validate(value);
    }

    public PhoneNumber() {
    }

    private void validate(String value) {
        this.lengthRule(value);
        this.regexRule(value);
    }

    private void regexRule(String value) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(value);
        if(!matcher.matches()) {
            throw new InvalidPhoneNumber("Invalid phone number format");
        }
    }

    private void lengthRule(String value) {
        if (value.length() > 15 || value.length() < 7) {
            throw new InvalidLength("Invalid phone number length");
        }
    }
}
