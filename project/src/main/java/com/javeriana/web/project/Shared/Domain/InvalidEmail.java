package com.javeriana.web.project.Shared.Domain;

public class InvalidEmail extends RuntimeException{
    public InvalidEmail(String message) {
        super(message);
    }
}

