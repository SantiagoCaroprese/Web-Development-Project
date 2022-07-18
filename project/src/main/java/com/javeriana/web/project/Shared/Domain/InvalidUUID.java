package com.javeriana.web.project.Shared.Domain;

public class InvalidUUID extends RuntimeException{
    public InvalidUUID(String message) {
        super(message);
    }
}
