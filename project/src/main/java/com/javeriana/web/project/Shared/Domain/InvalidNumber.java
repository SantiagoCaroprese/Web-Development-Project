package com.javeriana.web.project.Shared.Domain;

public class InvalidNumber extends RuntimeException{

    public InvalidNumber(String message) {
        super(message);
    }
}
