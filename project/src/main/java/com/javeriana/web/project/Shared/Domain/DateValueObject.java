package com.javeriana.web.project.Shared.Domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class DateValueObject {
    protected LocalDate value;

    public DateValueObject (LocalDate value){this.value = value;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateValueObject that = (DateValueObject) o;
        return Objects.equals(value, that.value);
    }

    public LocalDate value() {
        return value;
    }
}
