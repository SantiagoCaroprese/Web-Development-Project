package com.javeriana.web.project.PropertiesTest.OfferTests.ValueObjects;

import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Shared.Domain.InvalidNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new Price(1000000000));
    }

    @Test
    void should_throw_InvalidNumber_Negative() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new Price(-1));
        assertEquals("Invalid price number", exception.getMessage());
    }
    @Test
    void should_throw_InvalidNumber_Zero() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new Price(0));
        assertEquals("Invalid price number", exception.getMessage());
    }

    @Test
    void should_throw_InvalidNumber_9999() {
        Throwable exception = assertThrows(InvalidNumber.class, () -> new Price(9999));
        assertEquals("Invalid price number", exception.getMessage());
    }
}
