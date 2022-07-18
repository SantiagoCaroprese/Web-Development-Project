package com.javeriana.web.project.QuestionsTests.ValueObjects;


import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.Answer;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnswerTests {
    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new Answer("respuesta es esta"));
    }

    @Test
    void should_throw_InvalidLength() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new Answer(""));
        assertEquals("Invalid number of characters", exception.getMessage());
    }
}
