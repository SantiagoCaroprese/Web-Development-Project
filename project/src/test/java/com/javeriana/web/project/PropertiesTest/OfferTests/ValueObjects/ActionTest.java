package com.javeriana.web.project.PropertiesTest.OfferTests.ValueObjects;

import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Shared.Domain.Offers.OfferActionEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {
    @Test
    void should_not_throw_exceptions_arriendo() {
        assertAll(() -> new Action("RENT"));
    }

    @Test
    void should_not_throw_exceptions_venta() {
        assertAll(() -> new Action("SALE"));
    }
}
