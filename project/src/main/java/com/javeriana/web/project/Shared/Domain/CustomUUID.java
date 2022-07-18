package com.javeriana.web.project.Shared.Domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CustomUUID extends StringValueObject implements Serializable {

    public CustomUUID(String value) {
        super(value);
        this.validate(value);
    }

    public CustomUUID() {
    }

    private void validate(String value) {
        this.validateUUIDFormatRule(value);
    }

    private void validateUUIDFormatRule(String value) {
        try {
            UUID.fromString(value);
        }
        catch (Exception e){
            throw new InvalidUUID("Invalid UUID");
        }
    }

}
