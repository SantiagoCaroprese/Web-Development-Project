package com.javeriana.web.project.Shared.Domain;

public class InvalidPhoneNumber extends RuntimeException{
    public InvalidPhoneNumber(String message) {
        super(message);
    }
}
