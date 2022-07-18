package com.javeriana.web.project.QuestionsTests.QuestionTests;

import com.javeriana.web.project.Questions.Question.Application.AnswerQuestion.QuestionAnswerer;
import com.javeriana.web.project.Questions.Question.Application.CreateQuestion.QuestionCreator;
import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.QuestionDate;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.QuestionId;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.Text;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class QuestionTest {

    /*@Test
    void should_create_question(){
        QuestionRepository repository = mock(QuestionRepository.class);
        QuestionCreator creator = new QuestionCreator(repository);
        Question actualQuestion = new Question(new QuestionId("cc5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),
                new PropertyId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),
                new Text("¿Tienen asociaciones con bancos para un credito?"),
                new QuestionDate(LocalDate.now()));
        creator.execute("cc5f8ac3-b90d-40ec-b3e2-e0ca3f432721","bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721",
                "¿Tienen asociaciones con bancos para un credito?",LocalDate.now());
        verify(repository,atLeastOnce()).save(actualQuestion);
    }

    @Test
    void should_answer_question(){
        QuestionRepository repository = mock(QuestionRepository.class);
        QuestionAnswerer answerCreator = new QuestionAnswerer(repository);
        Question actualQuestion = new Question(new QuestionId("cc5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),
                new PropertyId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),
                new Text("¿Tienen asociaciones con bancos para un credito?"),
                new QuestionDate(LocalDate.now()));
        String answerText = "De momento no tenemos";
        answerCreator.execute(actualQuestion.getQuestionId().value(),answerText,actualQuestion);
        verify(repository,atLeastOnce()).update(actualQuestion.getQuestionId().value(),actualQuestion);
    }*/
}
