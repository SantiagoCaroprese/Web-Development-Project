package com.javeriana.web.project.Shared.Domain;

public class InvalidDate extends RuntimeException{
    public InvalidDate(String message) {
        super(message);
    }
}
