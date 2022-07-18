package com.javeriana.web.project.Shared.Domain;

public class InvalidLength extends RuntimeException{
    public InvalidLength(String message) {
        super(message);
    }
}
