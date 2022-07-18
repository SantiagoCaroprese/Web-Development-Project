package com.javeriana.web.project.QuestionsTests.ValueObjects;

import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.Text;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextTests {

    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new Text("Esta es la pregunta"));
    }

    @Test
    void should_throw_InvalidLength() {
        Throwable exception = assertThrows(InvalidLength.class, () -> new Text(""));
        assertEquals("Invalid number of characters", exception.getMessage());
    }

}
