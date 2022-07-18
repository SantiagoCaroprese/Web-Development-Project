package com.javeriana.web.project.Shared.Domain;

public class PastDateException extends RuntimeException{

    public PastDateException(String message) {
        super(message);
    }

}
