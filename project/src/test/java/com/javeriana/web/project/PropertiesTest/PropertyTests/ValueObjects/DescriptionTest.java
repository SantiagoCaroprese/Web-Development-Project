package com.javeriana.web.project.PropertiesTest.PropertyTests.ValueObjects;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.Description;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DescriptionTest {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new Description("Doe"));
    }

    @Test
    void should_throw_InvalidLength_Empty() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new Description(""));
        assertEquals("Invalid number of characters", exception.getMessage());
    }

    @Test
    void should_throw_InvalidLength_ToManyCharacters() {
        StringBuffer outputBuffer = new StringBuffer(600);
        for (int i = 0; i < 600; i++){
            outputBuffer.append(" ");
        }
        Throwable exception = assertThrows(InvalidLength.class, () -> new Description(outputBuffer.toString()));
        assertEquals("Invalid number of characters", exception.getMessage());
    }
}
