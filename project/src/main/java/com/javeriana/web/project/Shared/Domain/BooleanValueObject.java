package com.javeriana.web.project.Shared.Domain;

import java.util.Objects;

public class BooleanValueObject {

    protected Boolean value;

    public BooleanValueObject(boolean value) {
        this.value = value;
    }

    public BooleanValueObject() {

    }

    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooleanValueObject that = (BooleanValueObject) o;
        return Objects.equals(value, that.value);
    }
}
