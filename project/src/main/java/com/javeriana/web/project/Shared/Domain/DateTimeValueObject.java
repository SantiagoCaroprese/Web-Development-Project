package com.javeriana.web.project.Shared.Domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateTimeValueObject {
    private LocalDateTime value;

    public DateTimeValueObject(LocalDateTime value) {
        this.value = value;
    }

    public DateTimeValueObject() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTimeValueObject that = (DateTimeValueObject) o;
        return Objects.equals(value, that.value);
    }

    public LocalDateTime value() {
        return value;
    }

}
