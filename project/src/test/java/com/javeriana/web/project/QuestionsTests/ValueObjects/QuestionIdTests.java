package com.javeriana.web.project.QuestionsTests.ValueObjects;


import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.QuestionId;
import com.javeriana.web.project.Shared.Domain.InvalidUUID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionIdTests {


    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new QuestionId("4a229224-759d-4234-8871-ef352ca516ce"));
    }

    @Test
    void should_throw_InvalidUUID() {
        Throwable exception = assertThrows(InvalidUUID.class, () -> new QuestionId("4a229224-759d-4234-8871"));
        assertEquals("Invalid UUID", exception.getMessage());
    }
}
