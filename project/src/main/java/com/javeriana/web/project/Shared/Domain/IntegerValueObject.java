package com.javeriana.web.project.Shared.Domain;

import java.util.Objects;

public class IntegerValueObject {

    protected int value;

    public IntegerValueObject(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerValueObject that = (IntegerValueObject) o;
        return value == that.value;
    }
}
