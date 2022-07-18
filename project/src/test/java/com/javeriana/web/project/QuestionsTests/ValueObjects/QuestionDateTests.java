package com.javeriana.web.project.QuestionsTests.ValueObjects;

import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.QuestionDate;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.Text;
import com.javeriana.web.project.Shared.Domain.InvalidDate;
import com.javeriana.web.project.Shared.Domain.InvalidLength;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionDateTests {


    @Test
    void should_not_throw_exceptions() {
        assertAll(() -> new QuestionDate(LocalDate.of( 2014 , 2 , 11 )));
    }

    /*@Test
    void should_throw_DateTimeException() {

        Throwable exception = assertThrows(DateTimeException.class, () -> new QuestionDate(LocalDate.of( -2010 , 13 , 1 )));
        assertEquals("Invalid date", exception.getMessage());
    }*/

}
